package com.cheweek.spring_backend_cheweek_core.utility.sqlgenerator;



import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
@RequiredArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SQLFormatter {

    final RedisTemplate<String,String> redis;

    final Map<String,String> filter = new HashMap<>();



    public MapSqlParameterSource getFilter() {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        for (String key : filter.keySet()) {
            if (filter.get(key).contains("|")) {

                String[] ss = filter.get(key).split("\\|");
                final List<Object[]> employeeIds = new ArrayList<>();
                for (String id : ss) {
                    employeeIds.add(new Object[]{id});
                }
                mapSqlParameterSource.addValue(key, employeeIds);

            } else {
                final String val = filter.get(key);
                mapSqlParameterSource.addValue(key, val);
            }
        }
        return mapSqlParameterSource;
    }

    public String formatBySqlId(String id, Carrier carrier) {
        List<String> sqlParamList = new ArrayList<>();
        Map<String,String> map  = carrier.getKv();

//        String sql = "";
//        String rs = "";
//
//        try {
//            Resource resource = new ClassPathResource("sql/" + id + ".sql");
//            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
//            while (br.ready()) {
//            String line = br.readLine().trim()+" ";
//            if(line.startsWith("--")){
//                continue;
//            }
//                sql +=line ;
//            }
//        } catch (Exception e) {
//            new RuntimeException(e.getMessage());
//        }
//        if (sql.length() > 0) {
//           rs = format(sql, map, sqlParamList, this.filter);
//        }
//        return rs;
        return formatBySqlId(id,map,sqlParamList);
    }
    public String formatBySqlId(String id, Map<String,String> map) {
        List<String> sqlParamList = new ArrayList<>();
        return formatBySqlId(id,map,sqlParamList);
    }
    public String formatByQuery(String id, Map<String,String> map) {
        List<String> sqlParamList = new ArrayList<>();
        String rs = format(id, map, sqlParamList, this.filter);
        return rs;
    }
    public String formatBySqlId(String id, Map<String,String> map,List<String>sqlParamList) {
        String sql = "";
        String rs = "";

//        try {
//            Resource resource = new ClassPathResource("sql/" + id + ".sql");
//            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
//            while (br.ready()) {
//                String line = br.readLine().trim()+" ";
//                if(line.startsWith("--")){
//                    continue;
//                }
//                sql +=line ;
//            }
//        } catch (Exception e) {
//            new RuntimeException(e.getMessage());
//        }

        HashOperations<String,String,String> ln = redis.opsForHash();
      sql = ln.get("elcom_sql",id+".sql")   ;


        if (sql.length() > 0) {
            rs = format(sql, map, sqlParamList, this.filter);
        }
        return rs;
    }


    public String format(String query, Map<String, String> carrier, List<String> sqlParamList, Map<String, String> filter) {
        String ln = query;
        Map<String, String> cr = carrier;
        ln = adOperation(ln, carrier, cr);
        ln = diyesOperation(ln, carrier, cr);
        ln = tildaOperation(ln, carrier, cr);
        ln = cupOperation(ln, carrier);
        ln = yesOperation(ln, carrier);
        ln = setQuestionMarksAndValue(ln, cr, sqlParamList, filter);
        ln = removeUnusedParantheses(ln);

        return ln;
    }

    private String adOperation(String ln, Map<String, String> carrier, Map<String, String> cr) {
        String smAd = "@";
        String adParams[] = spritLineBySeperator(ln, smAd);
        for (String param : adParams) {
            String key = pureKey(param, smAd);
            String val = carrier.get(key) == null ?"":carrier.get(key) ;
            ln = ifEmptyRemoveParantesOrAddValue4Ad(ln, param, val, cr);
        }
        return ln;
    }

    private String ifEmptyRemoveParantesOrAddValue4Ad(String line, String key, String val, Map<String, String> cr) {
        if (val.trim().length() == 0) {

            int lineTemp = line.length();
            line = ifEmptyRemoveParantes(line, key, val);

            //if param is not midde of the paranthes
            if (lineTemp == line.length()) {
                line = line.replaceFirst(key, val);
            }
        } else {
            line = line.replaceFirst(key, val);

        }
        return line;
    }

    private String ifEmptyRemoveParantes(String line, String key, String val) {
        String ln = line;

        if (val.trim().length() == 0) {
            int index = line.indexOf(key);
            int left_paranthes_index = getLeftParanthesIndex(line, index, index);
            int right_paranthes_index = index + getRightParanthesIndex(line, index, 0);

            if (left_paranthes_index == -1 || right_paranthes_index == -1) {
                return ln;
            }

            int start_ind = (right_paranthes_index + 1 > line.length()) ? line.length() : right_paranthes_index + 1;
            ln = line.substring(0, left_paranthes_index) + line.substring(start_ind, line.length());

        }
        return ln;
    }

    private int getRightParanthesIndex(String line, int index, int start_index) {
        if (index == -1) {
            return 0;
        }
        line = line.trim();
        int return_index = 0;
        String core_line = line.substring(index, line.length());
        String filter_line = core_line.substring(start_index, core_line.length());
        int startIndex = filter_line.indexOf("}");

        if (startIndex == -1) {
            return start_index - 1;
        }

        String right_str = core_line.substring(0, start_index + startIndex);

        int open_number = right_str.split("\\{").length - 1;
        int close_number = right_str.split("\\}").length - 1;

        if (open_number == close_number) {
            return_index = start_index + startIndex;
        } else {
            return getRightParanthesIndex(line, index, start_index + startIndex + 1);
        }
        return return_index;
    }

    private int getLeftParanthesIndex(String line, int index, int start_index) {
        if (index == -1) {
            return -1;
        }

        int return_index = 0;
        String core_line = line.substring(0, index);
        String filter_line = line.substring(0, start_index);
        int startIndex = filter_line.lastIndexOf("{");
        if (startIndex == -1) {
            return -1;
        }

        String left_str = core_line.substring(startIndex + 1, core_line.length());

        int open_number = left_str.split("\\{").length - 1;
        int close_number = left_str.split("\\}").length - 1;

        if (open_number == close_number) {
            return_index = startIndex;
        } else {
            return getLeftParanthesIndex(line, index, startIndex);
        }
        return return_index;
    }

    private String pureKey(String key, String seperator) {
        return key.replaceAll(seperator, "");
    }

    private String[] spritLineBySeperator(String line, String seperator) {

        ArrayList<String> wordList = new ArrayList<>();
        Pattern pattern = Pattern.compile(seperator + "\\w+");

        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            wordList.add(matcher.group());
        }
        return wordList.toArray(new String[0]);

    }

    private String diyesOperation(String ln, Map<String, String> carrier, Map<String, String> cr) {
        String sm = "#";
        String diyesParams[] = spritLineBySeperator(ln, sm);
        for (String param : diyesParams) {
            String key = pureKey(param, sm);
            String val = carrier.get(key) == null ?"":carrier.get(key) ;
            ln = ifEmptyRemoveParantesOrAddValueForDiyes(ln, param, val, cr);
        }
        return ln;
    }

    private String ifEmptyRemoveParantesOrAddValueForDiyes(String line, String key, String val, Map<String, String> cr) {
        if (val.trim().length() == 0) {

            int lineTemp = line.length();
            line = ifEmptyRemoveParantes(line, key, val);

            //if param is not midde of the paranthes
            if (lineTemp == line.length()) {
                String idx = getAlphaNumericString(9);
                String tempVal = tempValue(idx);
                cr.put(tempVal, val);
                line = line.replaceFirst(key, tempVal);
            }
        } else {
            String idx4 = getAlphaNumericString(7);
            String tempVal = tempValue(idx4);
            cr.put(tempVal, val);
            line = line.replaceFirst(key, tempVal);

        }
        return line;
    }

    private String tempValue(String idx) {
        return "__TT__FF__" + idx;
    }

    private String getAlphaNumericString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "_"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    private String tildaOperation(String ln, Map<String, String> carrier, Map<String, String> cr) {
        String tildaSm = "~";
        String tildaParams[] = spritLineBySeperator(ln, tildaSm);
        for (String param : tildaParams) {
            String key = pureKey(param, tildaSm);
            String val = carrier.get(key) == null ?"":carrier.get(key) ;
            ln = ifEmptyRemoveParantesOrAddValueForTilda(ln, param, val, cr);
        }
        return ln;
    }

    private String ifEmptyRemoveParantesOrAddValueForTilda(String line, String key, String val, Map<String, String> cr) {
        if (val.trim().length() == 0) {

            int lineTemp = line.length();
//            line = ifEmptyRemoveParantes4Tilda(line, key, val);
            line = ifEmptyRemoveParantes(line, key, val);

            //if param is not midde of the paranthes
            if (lineTemp == line.length()) {
                String idx = getAlphaNumericString(9);
                String tempVal = tempValue4Tilda(idx);
                cr.put(tempVal, val);
                line = line.replaceFirst(key, tempVal);
            }
        } else {
            String idx4 = getAlphaNumericString(7);
            String tempVal = tempValue4Tilda(idx4);
            cr.put(tempVal, val);
            line = line.replaceFirst(key, tempVal);
        }
        return line;
    }

    private String tempValue4Tilda(String idx) {
        return "__TT__TD__" + idx;
    }

    private String cupOperation(String ln, Map<String, String> carrier) {

        ln = ln.trim();
        String seperator = "\\^";
        String tildaParams[] = spritLineBySeperator(ln, seperator);
        for (String param : tildaParams) {
            String key = pureKey(param, seperator);
            String val = carrier.get(key) == null ?"":carrier.get(key) ;
            ln = ifEmptyRemoveParantesOrAddValueForCup(ln, param, val);
        }
        return ln;
    }

    private String yesOperation(String ln, Map<String, String> carrier) {
        ln = ln.trim();
        String seperator = "\\&";
        String tildaParams[] = spritLineBySeperator(ln, seperator);
        for (String param : tildaParams) {
            String key = pureKey(param, seperator);
            String val = carrier.get(key) == null ?"":carrier.get(key) ;
            val = (val.length() > 0) ? "" : "___TEMP___";
            ln = ifEmptyRemoveParantesOrAddValueForCup(ln, param, val);
        }
        return ln;
    }

    private String ifEmptyRemoveParantesOrAddValueForCup(String line, String key, String val) {
        String ln = line;
        if (val.length() == 0) {
            ln = ifEmptyRemoveParantes(line, key, val);

            //if param is not midde of the paranthes
            if (ln.length() == line.length()) {
                ln = line.replace(key, "");
            }
        } else {
            ln = ln.replace(key, "");
        }

        return ln;
    }

    private String setQuestionMarksAndValue(String ln, Map<String, String> cr, List<String> sqlParamList, Map<String, String> filter) {


        String smAd = "__TT__";
        String adParams[] = spritLineBySeperator(ln, smAd);
        for (String param : adParams) {

            String val = cr.get(param) == null ?"":cr.get(param) ;

            if (param.contains("__FF__")) {
                sqlParamList.add(val);

                filter.put(param, val);
                ln = ln.replaceFirst(param, ":" + param);
            } else if (param.contains("__TD__")) {
                String valList[] = val.split("\\|");
                sqlParamList.addAll(Arrays.asList(valList));

                String qline = ":" + param;
                filter.put(param, val);
//                for (int i = 0; i < valList.length; i++) {
//                    qline += (i < valList.length - 1) ? "?," : "?";
//                }
                ln = ln.replaceFirst(param, qline);
            }
        }
        return ln;
    }

    private String removeUnusedParantheses(String ln) {
        String res = ln.replaceAll("\\{", "").replaceAll("}", "");
        return res;
    }


}