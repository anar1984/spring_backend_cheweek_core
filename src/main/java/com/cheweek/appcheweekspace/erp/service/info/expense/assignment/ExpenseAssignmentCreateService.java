package com.cheweek.appcheweekspace.erp.service.info.expense.assignment;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseAssignment;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseAssignmentCreateMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseAssignmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ExpenseAssignmentCreateService {

    final ExpenseAssignmentRepository expenseAssignmentRepository;
    final ExpenseAssignmentCreateMapper mapper;

    public void createExpenseAssignment(ExpenseAssignmentCreateDTO dto){

        ExpenseAssignment expenseAssignment =mapper.expenseAssignmentCreateDTOToEntity(dto);
        expenseAssignmentRepository.save(expenseAssignment);
    }
}
