package com.cheweek.appcheweekspace.erp.repository.info.hr;

import com.cheweek.appcheweekspace.erp.entity.info.hr.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, JpaSpecificationExecutor<Employee> {
    Optional<Employee> findByIdAndStatus(String id, String status);
}
