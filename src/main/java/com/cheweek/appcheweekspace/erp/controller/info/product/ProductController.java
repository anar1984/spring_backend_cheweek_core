package com.cheweek.appcheweekspace.erp.controller.info.product;

import com.cheweek.appcheweekspace.erp.dto.info.product.ProductInsertDTO;
import com.cheweek.appcheweekspace.erp.service.info.product.ProductInsertService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info/product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductController {

    final ProductInsertService productInsertService;

    @PostMapping("/insert")
    public ResponseEntity<?> store(@RequestBody ProductInsertDTO dto){
        productInsertService.insertProduct(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
