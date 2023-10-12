package com.cheweek.appcheweekspace.erp.mapper.expense;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseAssignmentCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseAssignment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseAssignmentCreateMapper {

    ExpenseAssignment expenseAssignmentCreateDTOToEntity(ExpenseAssignmentCreateDTO dto);

    ExpenseAssignmentCreateDTO expenseAssignmentCreateEntityToDTO(ExpenseAssignment expenseAssignment);
}
