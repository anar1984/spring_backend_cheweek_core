package com.cheweek.appcheweekspace.erp.repository.info.product;

import com.cheweek.appcheweekspace.erp.entity.info.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType,String> {
    ProductType findAllByIdAndStatus(String id, String status);
}
