package com.cheweek.appcheweekspace.core.repository.flow;

import com.cheweek.appcheweekspace.core.entity.flow.WarehouseFlowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WarehouseFlowRepository extends JpaRepository<WarehouseFlowEntity,String>, JpaSpecificationExecutor <WarehouseFlowEntity>{
}