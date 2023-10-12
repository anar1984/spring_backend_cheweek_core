package com.cheweek.appcheweekspace.erp.repository.info.transaction;

import com.cheweek.appcheweekspace.erp.entity.info.transaction.ChartOfAccount;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ChartOfAccountRepository extends JpaRepository<ChartOfAccount, String>,
        JpaSpecificationExecutor<ChartOfAccount> {

    ChartOfAccount findByIdAndStatus(String id, String status);
}
