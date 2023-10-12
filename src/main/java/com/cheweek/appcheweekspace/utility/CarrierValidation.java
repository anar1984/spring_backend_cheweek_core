package com.cheweek.appcheweekspace.utility;

import com.cheweek.appcheweekspace.utility.exception.FieldsNotFoundException;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Data
@Component
public class CarrierValidation {
    final SessionManager sessionManager;
    List<String> error = new ArrayList<>();

    public void addValidation(Carrier carrier,String key){
        if(carrier.get(key).trim().length()==0){
            this.error.add(key);
        }
    }

    public void hasError()  {
        Map<String ,String> response = new HashMap<>();
        for (String key : this.error){
            response.put(key,key);

        }
        if(this.error.size()>0){
            FieldsNotFoundException exception = new FieldsNotFoundException();
            exception.setErrorType("error");
            exception.setMessageCode("chw_"+exception.getStatusCode());
            exception.setParams(response);
            exception.setLang(sessionManager.getLang());

            throw exception;
        }
    }

}
