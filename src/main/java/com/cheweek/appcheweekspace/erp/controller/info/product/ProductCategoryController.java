package com.cheweek.appcheweekspace.erp.controller.info.product;

import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategoryListApiDTO;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategorySaveDTO;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategoryUpdateDTO;
import com.cheweek.appcheweekspace.erp.service.info.product.ProductCategoryDeleteService;
import com.cheweek.appcheweekspace.erp.service.info.product.ProductCategoryListApi;
import com.cheweek.appcheweekspace.erp.service.info.product.ProductCategorySaveService;
import com.cheweek.appcheweekspace.erp.service.info.product.ProductCategoryUpdateService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info/product/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategoryController  {
   final ProductCategoryListApi productCategoryListApi;
   final ProductCategoryUpdateService productCategoryUpdateService;
   final ProductCategorySaveService productCategorySaveService;
   final ProductCategoryDeleteService productCategoryDeleteService;

    @PostMapping("/read")
    public List<ProductCategoryListApiDTO> dtoList (@RequestBody ProductCategoryListApiDTO dto){
        return productCategoryListApi.getProductCategoryInfo(dto);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateProductCategory(@RequestBody ProductCategoryUpdateDTO dto){
        productCategoryUpdateService.productCategoryUpdate(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveProductCategory(@RequestBody ProductCategorySaveDTO dto){
        productCategorySaveService.saveProductCategory(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delete")
    @Validated
    public ResponseEntity<?> deleteProductById(@Valid @RequestBody GetObjectById dto){
        productCategoryDeleteService.deleteProductCategory(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
