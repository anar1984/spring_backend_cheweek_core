package com.cheweek.appcheweekspace.erp.mapper.expense;


import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseAssignment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseAssignmentUpdateMapper {
    ExpenseAssignment expenseAssignmentReadDTOToEntity(ExpenseAssignmentUpdateDTO dto);

    ExpenseAssignmentUpdateDTO expenseAssignmentReadEntityToDTO(ExpenseAssignment expenseAssignment);
}
