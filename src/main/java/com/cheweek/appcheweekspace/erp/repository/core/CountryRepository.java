package com.cheweek.appcheweekspace.erp.repository.core;

import com.cheweek.appcheweekspace.erp.entity.core.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String>, JpaSpecificationExecutor<Country> {
    List<Country> findAllByStatus(String status);
}
