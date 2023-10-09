package com.cheweek.spring_backend_cheweek_core.controller.info;

import com.cheweek.spring_backend_cheweek_core.dto.PropertiesDTO;
import com.cheweek.spring_backend_cheweek_core.service.impl.TestDtoGetService;
import com.cheweek.spring_backend_cheweek_core.service.info.PropertiesGetService;
import com.cheweek.spring_backend_cheweek_core.service.info.PropertiesServiceSave;
import com.cheweek.spring_backend_cheweek_core.service.info.PropertiesSetRedis;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
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
   final PropertiesServiceSave  propertiesServiceSave;
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
