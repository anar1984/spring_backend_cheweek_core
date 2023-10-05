package com.cheweek.spring_backend_cheweek_core.utility.coreentity;



import com.cheweek.spring_backend_cheweek_core.utility.exception.TableRowLimitException;
import com.cheweek.spring_backend_cheweek_core.utility.Converter;
import com.cheweek.spring_backend_cheweek_core.utility.QDate;
import com.cheweek.spring_backend_cheweek_core.utility.QLogger;
import com.cheweek.spring_backend_cheweek_core.utility.SessionManager;
import com.cheweek.spring_backend_cheweek_core.utility.sqlgenerator.SQLFormatter;
import com.google.gson.Gson;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class CoreEntityListener {
    final QLogger logger = QLogger.getLogger(CoreEntityListener.class);
    @Autowired
    private SessionManager manager;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private SQLFormatter formatter;
    @PrePersist
    private void preInsert(CoreEntity entity){
        checkTableInsert(entity);
        entity.setInsertDate( QDate.getCurrentDate());
        entity.setStatus("A");
        entity.setCreatedDate(QDate.getCurrentDate());
        entity.setCreatedTime(QDate.getCurrentTime());
        entity.setCreatedBy(manager.getCurrentUserId());
    }


    @PreUpdate
    private void preUpdate(CoreEntity entity){
        entity.setModificationDate( QDate.getCurrentDate());
        entity.setModificationBy(manager.getCurrentUserId());
        entity.setModificationTime(QDate.getCurrentTime());

    }

    private void checkTableInsert(CoreEntity entity){
       String entityName = entity.getClass().getSimpleName();
       Map<String,String> map = new HashMap<>();
        Converter converter= new Converter();
        map = converter.convertDto(entity);
        String rs = "";
        try {
            Resource resource =  new ClassPathResource("config/"+entityName+".json");
            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
            while (br.ready()) {
            String line = br.readLine().trim()+" ";
                rs +=line ;
            }
        } catch (Exception e) {
            return;
        }

        Gson gson = new Gson();
        EntityControl control  = gson.fromJson(rs,EntityControl.class);
        logger.info(control.toString());

            if(control.getEntityName().equals(entityName)){


                String tableName = control.getTableName();
                int count = control.getControlCount();
                String groupStr = control.getControlFields();
                if(groupStr==null || groupStr.trim().length()==0){
                    return;
                }
                String sql = getSql(groupStr, tableName);
                sql = formatter.formatByQuery(sql,map);
                MapSqlParameterSource mapSqlParameterSource = formatter.getFilter();
                SqlRowSet set = namedParameterJdbcTemplate.queryForRowSet(sql,mapSqlParameterSource);
                while (set.next()){
                    String rowCount = set.getString("row_count")==null?"0":set.getString("row_count");
                    int rsCount = Integer.parseInt(rowCount);
                    if(count<rsCount){
//                        throw new RuntimeException("Table out of limit !!!");
                        TableRowLimitException exception = new TableRowLimitException();
                        exception.setMessageCode("604");
                        exception.setMessage("Table limit out of bound");
                        throw exception;

                    }else{
                        break;
                    }
                }


            }



    }

    private static String getSql(String groupStr, String tableName) {
        String [] group= groupStr.split(",");
        String filter = "";
        for (String str : group){
            String columName = "";
            String []columNames = str.split("(?=[A-Z])|(?<=\\\\D)(?=\\\\d)|(?<=\\\\d)(?=\\\\D)");
            for (int j = 0 ;j <columNames.length;j++){
                if(j<columNames.length-1){
                    columName+=columNames[j].toLowerCase()+"_";
                }else if(j==columNames.length-1){
                    columName+=columNames[j].toLowerCase();
                }
            }
            filter +=filter+" and "+" "+columName+" = #"+str;
        }

        String sql = "Select count(*) as row_count from "+ tableName + " where status='A' "+filter+" ;";
        return sql;
    }

}
