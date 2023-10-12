package com.cheweek.appcheweekspace.erp.repository.core;

import com.cheweek.appcheweekspace.erp.entity.core.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String>, JpaSpecificationExecutor<City> {
    List<City> findAllByFkCountryIdAndStatus(String fkCountryId, String status);
}
