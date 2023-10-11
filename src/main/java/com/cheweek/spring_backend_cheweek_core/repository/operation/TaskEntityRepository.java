package com.cheweek.spring_backend_cheweek_core.repository.operation;

import com.cheweek.spring_backend_cheweek_core.entity.operation.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskEntityRepository extends JpaRepository<TaskEntity,String>, JpaSpecificationExecutor<TaskEntity> {
}