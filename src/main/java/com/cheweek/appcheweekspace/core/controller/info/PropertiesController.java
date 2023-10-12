package com.cheweek.appcheweekspace.core.controller.info;

import com.cheweek.appcheweekspace.core.dto.PropertiesDTO;
import com.cheweek.appcheweekspace.core.service.impl.TestDtoGetService;
import com.cheweek.appcheweekspace.core.service.info.PropertiesGetService;
import com.cheweek.appcheweekspace.core.service.info.PropertiesServiceSave;
import com.cheweek.appcheweekspace.core.service.info.PropertiesSetRedis;
import com.cheweek.appcheweekspace.utility.Carrier;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertiesController {

   final PropertiesGetService service;
   final TestDtoGetService testDtoGetService;
   final PropertiesServiceSave propertiesServiceSave;
   final PropertiesSetRedis propertiesSetRedis;
    @PostMapping("/get")
    public Carrier getProduct(@RequestBody Carrier carrier){
        return service.run(carrier);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody PropertiesDTO carrier){
        propertiesServiceSave.save(carrier);
        return  null;
    }

    @PostMapping("/get_dto")
    public Carrier getProductByTest(@RequestBody Carrier carrier){
        return testDtoGetService.run(carrier);
    }
    @GetMapping("/set-redis")
    public Carrier getPropertiesSetRedis(@RequestBody Carrier carrier){
        propertiesSetRedis.setPropertiesToRedis();
        return carrier;
    }
}
