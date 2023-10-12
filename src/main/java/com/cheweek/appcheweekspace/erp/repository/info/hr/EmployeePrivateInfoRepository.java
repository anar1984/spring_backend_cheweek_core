package com.cheweek.appcheweekspace.erp.repository.info.hr;

import com.cheweek.appcheweekspace.erp.entity.info.hr.EmployeePrivateInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EmployeePrivateInfoRepository extends JpaRepository<EmployeePrivateInfo, String>, JpaSpecificationExecutor<EmployeePrivateInfo> {
    Optional<EmployeePrivateInfo> findByFkUserIdAndStatus(String fkUserId, String status);
}
