package com.cheweek.appcheweekspace.erp.repository.info.expense;

import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ExpenseAssignmentRepository extends JpaRepository<ExpenseAssignment,String>, JpaSpecificationExecutor<ExpenseAssignment> {
}
