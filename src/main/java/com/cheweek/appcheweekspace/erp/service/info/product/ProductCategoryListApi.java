package com.cheweek.appcheweekspace.erp.service.info.product;

import com.cheweek.appcheweekspace.erp.repository.info.product.ProductCategoryRepository;
import com.cheweek.appcheweekspace.erp.dto.info.product.ProductCategoryListApiDTO;
import com.cheweek.appcheweekspace.erp.entity.info.product.ProductCategory;
import com.cheweek.appcheweekspace.erp.mapper.product.ProductCategoryMapper;
import com.cheweek.appcheweekspace.utility.coreentity.CorePagination;
import com.cheweek.appcheweekspace.utility.coreentity.CoreSpecification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategoryListApi  {
    final ProductCategoryRepository productCategoryRepository;
    final ProductCategoryMapper mapper;
    final CorePagination pagination;
    public List<ProductCategoryListApiDTO> getProductCategoryInfo(ProductCategoryListApiDTO dto) {
        CoreSpecification<?> specification =CoreSpecification.getInstance();
        specification.setAndLike("categoryName",dto.getCategoryName());
        specification.setAnd("fkProductTypeId",dto.getFkProductTypeId());
        specification.setAnd("direction",dto.getDirection());
        specification.setAnd("createdDate",dto.getCreatedDate());
        specification.setAnd("isActive",dto.getIsActive());
        String page = dto.getPage();

        List<ProductCategory> productCategoryList =productCategoryRepository.findAll(specification.getSpecification(),pagination.getPagination(page,"50")).stream().toList();;

        return mapper.productCategoryToproductCategoryListApiDTO(productCategoryList);
    }
}
