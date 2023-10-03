package com.cheweek.spring_backend_cheweek_core.controller.info;

import com.cheweek.spring_backend_cheweek_core.service.info.ProductTypeGetService;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-type")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductTypeController {
    final ProductTypeGetService productTypeGetService;

    @PostMapping("/get")
    public Carrier productTypeGet(@RequestBody Carrier carrier){
        return productTypeGetService.run(carrier);
    }
}
