package com.cheweek.appcheweekspace.utility;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Data
@Component
public class ValidationCarrier {

    private List<String> errors = new ArrayList<>();

    public void controllerField(Carrier carrier,String field){
        if(carrier.getKv().get(field) == null || carrier.getKv().get(field).trim().length()==0){
            errors.add(field);
            throw new RuntimeException("This field "+field+" is not empty");

        }

    }
    public void controllerField(Carrier carrier,List<String> fields){
        for (String field : fields){
            if(carrier.getKv().get(field) == null || carrier.getKv().get(field).trim().length()==0){
                errors.add(field);

            }
        }

    }




}
