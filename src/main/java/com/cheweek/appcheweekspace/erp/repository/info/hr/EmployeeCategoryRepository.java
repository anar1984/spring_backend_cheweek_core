package com.cheweek.appcheweekspace.erp.repository.info.hr;

import com.cheweek.appcheweekspace.erp.entity.info.hr.EmployeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface EmployeeCategoryRepository extends JpaRepository<EmployeeCategory, String>, JpaSpecificationExecutor<EmployeeCategory> {

    List<EmployeeCategory> findAllByEmployeeStatusAndStatus(String employeeStatus, String status);
}
