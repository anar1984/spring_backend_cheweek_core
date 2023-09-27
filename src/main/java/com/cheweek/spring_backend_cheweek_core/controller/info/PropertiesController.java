package com.cheweek.spring_backend_cheweek_core.controller.info;

import com.cheweek.spring_backend_cheweek_core.service.info.PropertiesGetService;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core/properties")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertiesController {

   final PropertiesGetService service;
    @PostMapping("/get")
    public Carrier getProduct(@RequestBody Carrier carrier){
        return service.run(carrier);
    }
}
