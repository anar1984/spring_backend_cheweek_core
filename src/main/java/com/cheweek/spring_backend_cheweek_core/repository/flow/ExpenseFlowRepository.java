package com.cheweek.spring_backend_cheweek_core.repository.flow;

import com.cheweek.spring_backend_cheweek_core.entity.flow.ExpenseFlowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ExpenseFlowRepository extends JpaRepository<ExpenseFlowEntity,String>, JpaSpecificationExecutor<ExpenseFlowEntity> {
}
