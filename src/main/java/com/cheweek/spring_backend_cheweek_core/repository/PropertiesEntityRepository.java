package com.cheweek.spring_backend_cheweek_core.repository;

import com.cheweek.spring_backend_cheweek_core.entity.PropertiesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesEntityRepository extends JpaRepository<PropertiesEntity,String>, JpaSpecificationExecutor<PropertiesEntity> {
    Page<PropertiesEntity>  findAllByPropertyCodeAndStatusAndIsActive(String propertyCode, String status, String isActive, Pageable pageable);


//    propertyKey
//    propertyValuec

//    List<TestMyProjection> getAllByPropertyCodeAndStatusAndIsActive(String propertyCode, String status, String isActive);




}
