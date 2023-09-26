package com.cheweek.spring_backend_cheweek_core.utility.sqlgenerator;



import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import com.cheweek.spring_backend_cheweek_core.utility.QLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class SQLGenerator<T> {
    final QLogger logger = QLogger.getLogger(SQLGenerator.class);
    final SQLFormatter formatter;
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final

    public List<T> selectSql(Carrier carrier, String queryName, RowMapper<T> rowMapper) {
        return selectSql(carrier.getKv(),queryName,rowMapper);
    }

    public List<T> selectSql(Map<String, String> inputParam, String queryName, RowMapper<T> rowMapper) {
        String rs = formatter.formatBySqlId(queryName, inputParam);
        MapSqlParameterSource mapSqlParameterSource = formatter.getFilter();
        List<T> list = namedParameterJdbcTemplate.query(rs, mapSqlParameterSource, rowMapper);
        return list;
    }
    public List<T> selectSql(Map<String, String> inputParam, String queryName,T t) {
        String rs = formatter.formatBySqlId(queryName, inputParam);
        MapSqlParameterSource mapSqlParameterSource = formatter.getFilter();
        List<T> list = (List<T>) namedParameterJdbcTemplate.query(rs, mapSqlParameterSource,(r, rowNum) -> rowMapper(r,t));
        return list;
    }

    public List<T> selectSql(Map<String, String> inputParam, String queryName,String selectedField) {
        String rs = formatter.formatBySqlId(queryName, inputParam);
        MapSqlParameterSource mapSqlParameterSource = formatter.getFilter();
        List<T> list = namedParameterJdbcTemplate.query(rs, mapSqlParameterSource,(r, rowNum) -> rowMapper(r,selectedField));
        return list;
    }

    public List<T> selectSql(Carrier carrier, String queryName,T t) {
        return selectSql(carrier.getKv(),queryName,t);
    }




    public SqlRowSet selectSql(Map<String, String> inputParam, String queryName) {
        String rs = formatter.formatBySqlId(queryName, inputParam);
        MapSqlParameterSource mapSqlParameterSource = formatter.getFilter();
        SqlRowSet set = namedParameterJdbcTemplate.queryForRowSet(rs, mapSqlParameterSource);
        return set;
    }

    public SqlRowSet selectSql(Carrier carrier, String queryName) {
        return selectSql(carrier.getKv(),queryName);
    }

    public Carrier selectToCarrier(Carrier carrier, String queryName, RowMapper<T> rowMapper) {
        return selectToCarrier(carrier.getKv(),queryName,rowMapper);
    }


    public Carrier selectToCarrier(Map<String, String> inputParam, String queryName, RowMapper<T> rowMapper) {
        Carrier res = new Carrier();
        List<T> list = selectSql(inputParam, queryName, rowMapper);
        res.setList(queryName, list);
        return res;
    }
    public Carrier selectToCarrier(Map<String, String> inputParam, String queryName, String selectList) {
        Carrier res = new Carrier();
        List<T> list = selectSql(inputParam, queryName, selectList);
        res.setList(queryName, list);
        return res;
    }
    public Carrier selectToCarrier(Carrier carrier, String queryName, String selectList) {
        return selectToCarrier(carrier.getKv(),queryName,selectList);
    }
    public Carrier selectToCarrier(Carrier carrier, String queryName,T t) {
        return selectToCarrier(carrier.getKv(),queryName,t);
    }
    public Carrier selectToCarrier(Map<String, String> inputParam, String queryName,T t) {
        Carrier res = new Carrier();
        List<T> list = selectSql(inputParam, queryName,t);
        res.setList(queryName, list);
        return res;
    }

    public Carrier selectToCarrier(Map<String, String> inputParam, String queryName) {
        Carrier res = new Carrier();
        SqlRowSet set = selectSql(inputParam, queryName);
        res.setList(queryName, rowSetToMap(set));
        return res;
    }

    public Carrier selectToCarrier(Carrier carrier, String queryName) {
        return selectToCarrier(carrier.getKv(),queryName);
    }


    public List<Map<String, String>> selectToListMap(Map<String, String> inputParam, String queryName) {
        SqlRowSet set = selectSql(inputParam, queryName);
        return rowSetToMap(set);
    }

    public List<Map<String, String>> selectToListMap(Carrier carrier, String queryName) {
        SqlRowSet set = selectSql(carrier.getKv(), queryName);
        return rowSetToMap(set);
    }
    public List<Map<String, String>> selectToListMap(Carrier carrier, String queryName,String selectList) {
        return (List<Map<String, String>>) selectSql(carrier.getKv(),queryName,selectList);
    }

    private List<Map<String, String>> rowSetToMap(SqlRowSet set) {
        SqlRowSetMetaData metaData = set.getMetaData();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> columnMap = new HashMap<>();

        int rc = metaData.getColumnCount();
        for (int i = 1; i <= rc; i++) {
            String columnKey = metaData.getColumnName(i);
            String[] column = columnKey.split("_");
            String columnValue = "";
            for (int j = 0; j < column.length; j++) {
                columnValue += (j == 0) ? (column[j]) : (column[j].substring(0, 1).toUpperCase() + column[j].substring(1));
            }
            columnMap.put(columnKey, columnValue);
        }


        while (set.next()) {
            Map<String, String> map = new HashMap<>();
            for (String key : columnMap.keySet()) {
                map.put(columnMap.get(key),set.getString(key));
            }
            list.add(map);
        }
        return list;

    }

    private  T rowMapper( ResultSet set,T instance)  {

        Method[] methods = instance.getClass().getMethods();
        List<String> setColumnName = new ArrayList<>();
        try {
           ResultSetMetaData data  = set.getMetaData();
         int  row =    data.getColumnCount();
         for (int i = 1;i<=row;i++){
             setColumnName.add(data.getColumnName(i));
         }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Method  i :methods) {
            if(i.getName().startsWith("set")){
                try {
                    String columName = "";
                    String []columNames = i.getName().split("(?=[A-Z])|(?<=\\\\D)(?=\\\\d)|(?<=\\\\d)(?=\\\\D)");
                    for (int j = 0 ;j <columNames.length;j++){
                        if(j>0 && j<columNames.length-1){
                            columName+=columNames[j].toLowerCase()+"_";
                        }else if(j==columNames.length-1){
                            columName+=columNames[j].toLowerCase();
                        }
                    }
                    if(columName.trim().length()>0 && setColumnName.contains(columName.trim())){
                        i.invoke(instance,set.getString(columName))  ;
                    } else if (columName.trim().length()>0) {
                        i.invoke(instance,new String());

                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


        }
        return instance;
    }

    private  T rowMapper( ResultSet set,String selectList)  {
        String[] selectValue = selectList.split(",");
        Map<String,String> key = new HashMap<>();
        for (int i = 0; i < selectValue.length; i++) {
            String []fields  = selectValue[i].split("_");
            String field = "";
            for (int j = 0; j < fields.length; j++) {
                if (j==0){
                   field+=fields[j];
                }else {
                    field+=fields[j].substring(0,1).toUpperCase()+fields[j].substring(1);
                }
            }
            try {
                   key.put(field,set.getString(selectValue[i])==null?"\"\"":set.getString(selectValue[i]));
            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }
        return (T) key;
    }
}
