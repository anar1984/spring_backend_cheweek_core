package com.cheweek.appcheweekspace.erp.service.info.product;

import com.cheweek.appcheweekspace.erp.repository.info.product.ProductCategoryRepository;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;
import com.cheweek.appcheweekspace.erp.entity.info.product.ProductCategory;
import com.cheweek.appcheweekspace.erp.mapper.product.ProductCategoryMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategoryDeleteService {
    final ProductCategoryRepository productCategoryRepository;
    final ProductCategoryMapper mapper;
    public void deleteProductCategory(GetObjectById dto){
        ProductCategory productCategory = mapper.productCategoryDeleteServiceDTOtoProductCategory(dto);
        Optional<ProductCategory> category = productCategoryRepository.findById(dto.getId());
        category.orElseThrow(RuntimeException::new);
        productCategory.setStatus("D");
        productCategoryRepository.save(productCategory);
    }
}
