package com.cheweek.appcheweekspace.core.repository.operation;

import com.cheweek.appcheweekspace.core.entity.operation.ProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProcessEntityRepository extends JpaRepository<ProcessEntity,String>, JpaSpecificationExecutor<ProcessEntity> {
}
