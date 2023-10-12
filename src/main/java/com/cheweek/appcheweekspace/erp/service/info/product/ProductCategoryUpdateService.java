package com.cheweek.appcheweekspace.erp.service.info.product;

import com.cheweek.appcheweekspace.erp.repository.info.product.ProductCategoryRepository;
import com.cheweek.appcheweekspace.erp.repository.info.product.ProductTypeRepository;
import com.cheweek.appcheweekspace.erp.custom_exception.ProductTypeNotFoundException;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategoryUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.product.ProductCategory;
import com.cheweek.appcheweekspace.erp.entity.info.product.ProductType;
import com.cheweek.appcheweekspace.erp.mapper.product.ProductCategoryMapper;
import com.cheweek.appcheweekspace.erp.custom_exception.IdNotFoundException;
import com.cheweek.appcheweekspace.utility.core.RedisService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategoryUpdateService {
    final ProductCategoryRepository productCategoryRepository;
    final ProductTypeRepository productTypeRepository;
    final ProductCategoryMapper mapper;
    final RedisService redisService;

    public void productCategoryUpdate(ProductCategoryUpdateDTO productCategoryUpdateDTO) {

        ProductCategory category = productCategoryRepository.findAllByIdAndStatus(productCategoryUpdateDTO.getId(),"A");
        if(productCategoryUpdateDTO.getFkProductTypeId()!=null){
        ProductType productType = productTypeRepository.findAllByIdAndStatus(productCategoryUpdateDTO.getFkProductTypeId(),"A");
            if (productType == null){
                throw new ProductTypeNotFoundException();
            }
        } else {
            productCategoryUpdateDTO.setFkProductTypeId(category.getFkProductTypeId());
        }
        if(productCategoryUpdateDTO.getDirection()!=null){
            // api yazilmalidi
        }
        else {
            productCategoryUpdateDTO.setDirection(category.getDirection());
        }

//        Boolean typeExist = productCategoryRepository.findByFkProductTypeIdAndCategoryName(productCategoryUpdateDTO.getFkProductTypeId(), productCategoryUpdateDTO.getCategoryName());
        if(category==null){
            throw new IdNotFoundException();
        }

        ProductCategory productCategory =mapper.productCategoryUpdateDTOToProductCategory(productCategoryUpdateDTO);
        productCategory.setStatus(category.getStatus());
        productCategory.setCreatedBy(category.getCreatedBy());
        productCategory.setInsertDate(category.getInsertDate());
        productCategory.setCreatedTime(category.getCreatedTime());
        productCategory.setCreatedDate(category.getCreatedDate());

        productCategoryRepository.save(productCategory);

    }
}
