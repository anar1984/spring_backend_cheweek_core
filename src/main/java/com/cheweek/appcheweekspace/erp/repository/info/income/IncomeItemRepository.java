package com.cheweek.appcheweekspace.erp.repository.info.income;

import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IncomeItemRepository extends JpaRepository<IncomeItem,String>, JpaSpecificationExecutor<IncomeItem> {
}
