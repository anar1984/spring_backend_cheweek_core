package com.cheweek.spring_backend_cheweek_core.utility.sqlgenerator;


import com.cheweek.spring_backend_cheweek_core.utility.QDate;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class IdGenerator  implements IdentifierGenerator , Configurable {

   private String prefix = "";


//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) {
//        int randomNum = 1000 + (int) (Math.random() * 9999);
////        String id = year + month + day + hr + min + sec + String.valueOf(randomNum);
//         prefix = QDate.getCurrentDate().substring(2, 8)  + QDate.getCurrentTime()
//                + QDate.getCurrentMillisecond()+String.valueOf(randomNum) ;
//        return prefix;
//    }
//    @Override
//    public void configure(Type type, Properties properties,
//                          ServiceRegistry serviceRegistry) throws MappingException {
//        prefix = properties.getProperty("prefix");
//    }



//    @Override
    public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) {
        IdentifierGenerator.super.configure(type, parameters, serviceRegistry);
        prefix = parameters.getProperty("prefix");
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        int randomNum = 1000 + (int) (Math.random() * 9999);
//        String id = year + month + day + hr + min + sec + String.valueOf(randomNum);
        prefix = QDate.getCurrentDate().substring(2, 8)  + QDate.getCurrentTime()
                + QDate.getCurrentMillisecond()+String.valueOf(randomNum) ;
        return prefix;
    }
}


