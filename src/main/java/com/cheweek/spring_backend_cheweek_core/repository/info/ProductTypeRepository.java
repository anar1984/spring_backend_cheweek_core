package com.cheweek.spring_backend_cheweek_core.repository.info;

import com.cheweek.spring_backend_cheweek_core.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType,String>, JpaSpecificationExecutor<ProductType> {
}
