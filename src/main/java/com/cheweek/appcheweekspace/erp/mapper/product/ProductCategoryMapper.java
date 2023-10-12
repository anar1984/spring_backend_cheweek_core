package com.cheweek.appcheweekspace.erp.mapper.product;

import com.cheweek.appcheweekspace.erp.dto.info.product.GetProductCategoryInfoDTO;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategoryListApiDTO;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategorySaveDTO;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategoryUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.product.ProductCategory;
import com.cheweek.appcheweekspace.erp.dto.core.GetObjectById;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    ProductCategory getProductCategoryInfoDTOToProductCategory (GetProductCategoryInfoDTO dto);
    ProductCategory productCategoryListApiDTOMapToProductCategory(ProductCategoryListApiDTO dto);
    List<ProductCategoryListApiDTO> productCategoryToproductCategoryListApiDTO(List<ProductCategory> categories);
    ProductCategory productCategorySaveDTOMapToProductCategory(ProductCategorySaveDTO dto);
    ProductCategory productCategoryUpdateDTOToProductCategory(ProductCategoryUpdateDTO dto);
    ProductCategory productCategoryDeleteServiceDTOtoProductCategory(GetObjectById dto);

}
