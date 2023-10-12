package com.cheweek.appcheweekspace.erp.service.info.expense.assignment;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseAssignment;
import com.cheweek.appcheweekspace.erp.mapper.expense.ExpenseAssignmentUpdateMapper;
import com.cheweek.appcheweekspace.erp.repository.info.expense.ExpenseAssignmentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseAssignmentUpdateService {

    final ExpenseAssignmentRepository expenseAssignmentRepository;
    final ExpenseAssignmentUpdateMapper mapper;

    public void updateExpenseAssignment(ExpenseAssignmentUpdateDTO dto){

        ExpenseAssignment expenseAssignment = mapper.expenseAssignmentReadDTOToEntity(dto);

        Optional<ExpenseAssignment> defaultFields = expenseAssignmentRepository.findById(expenseAssignment.getId());
        expenseAssignment.setCreatedBy(defaultFields.get().getCreatedBy());
        expenseAssignment.setCreatedDate(defaultFields.get().getCreatedDate());
        expenseAssignment.setCreatedTime(defaultFields.get().getCreatedTime());
        expenseAssignment.setInsertDate(defaultFields.get().getInsertDate());
        expenseAssignment.setStatus(defaultFields.get().getStatus());

        expenseAssignmentRepository.save(expenseAssignment);
    }
}
