package com.cheweek.appcheweekspace.erp.service.info.product;

import com.cheweek.appcheweekspace.erp.repository.info.product.ProductCategoryRepository;
import com.cheweek.appcheweekspace.erp.repository.info.product.ProductTypeRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.ProductTypeNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategorySaveDTO;
import com.cheweek.appcheweekspace.erp.entity.info.product.ProductCategory;
import com.cheweek.appcheweekspace.erp.entity.info.product.ProductType;
import com.cheweek.appcheweekspace.erp.mapper.product.ProductCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategorySaveService {
    final ProductCategoryRepository productCategoryRepository ;
    final ProductCategoryMapper mapper;
    final ProductTypeRepository productTypeRepository;

    public void saveProductCategory(ProductCategorySaveDTO dto){
        ProductCategory productCategory = mapper.productCategorySaveDTOMapToProductCategory(dto);
        Optional<ProductType> productType = productTypeRepository.findById(productCategory.getFkProductTypeId());
        productType.orElseThrow(ProductTypeNotFoundException::new);
        productCategoryRepository.save(productCategory);
    }
}
