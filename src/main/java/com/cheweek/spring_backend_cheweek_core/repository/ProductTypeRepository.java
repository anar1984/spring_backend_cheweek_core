package com.cheweek.spring_backend_cheweek_core.repository;

import com.cheweek.spring_backend_cheweek_core.entity.CoreProperties;
import com.cheweek.spring_backend_cheweek_core.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType,String> {
}
