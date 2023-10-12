package com.cheweek.appcheweekspace.erp.repository.info.product;

import com.cheweek.appcheweekspace.erp.entity.info.product.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductGroupRepository extends JpaRepository<ProductGroup,String> {
}
