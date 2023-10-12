package com.cheweek.appcheweekspace.erp.repository.info.product;

import com.cheweek.appcheweekspace.erp.entity.info.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String> , JpaSpecificationExecutor<ProductCategory> {
    Boolean findByFkProductTypeIdAndCategoryName(String fkProductTypeId,String categoryName);
    ProductCategory findAllByIdAndStatus(String id , String status);
}
