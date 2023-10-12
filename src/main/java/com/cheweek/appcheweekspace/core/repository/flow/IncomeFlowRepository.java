package com.cheweek.appcheweekspace.core.repository.flow;

import com.cheweek.appcheweekspace.core.entity.flow.IncomeFlowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IncomeFlowRepository extends JpaRepository<IncomeFlowEntity,String>, JpaSpecificationExecutor<IncomeFlowEntity> {
}
