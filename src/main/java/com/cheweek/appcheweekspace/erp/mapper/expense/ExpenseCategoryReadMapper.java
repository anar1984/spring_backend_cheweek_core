package com.cheweek.appcheweekspace.erp.mapper.expense;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryReadDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseCategoryReadMapper {

    ExpenseCategory expenseCategoryReadDTOToEntity(ExpenseCategoryReadDTO dto);

    ExpenseCategoryReadDTO expenseCategoryReadEntityToDTO(ExpenseCategory expenseCategory);
}
