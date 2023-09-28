package com.cheweek.spring_backend_cheweek_core.repository;

import com.cheweek.spring_backend_cheweek_core.dto.TestDto;
import com.cheweek.spring_backend_cheweek_core.entity.CoreProperties;
import com.cheweek.spring_backend_cheweek_core.projection.TestMyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorePropertiesRepository extends JpaRepository<CoreProperties,String> {
    List<CoreProperties> findAllByPropertyCodeAndStatusAndIsActive(String propertyCode,String status,String isActive);
//    propertyKey
//    propertyValue

    List<TestMyProjection> getAllByPropertyCodeAndStatusAndIsActive(String propertyCode, String status, String isActive);


}
