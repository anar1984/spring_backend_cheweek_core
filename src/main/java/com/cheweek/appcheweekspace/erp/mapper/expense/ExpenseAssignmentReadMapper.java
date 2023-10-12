package com.cheweek.appcheweekspace.erp.mapper.expense;


import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentReadDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseAssignment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseAssignmentReadMapper {

    ExpenseAssignment expenseAssignmentReadDTOToEntity(ExpenseAssignmentReadDTO dto);

    ExpenseAssignmentReadDTO expenseAssignmentReadEntityToDTO(ExpenseAssignment expenseAssignment);
}
