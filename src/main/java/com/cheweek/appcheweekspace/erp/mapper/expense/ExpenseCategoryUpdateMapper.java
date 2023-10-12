package com.cheweek.appcheweekspace.erp.mapper.expense;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseCategoryUpdateMapper {

    ExpenseCategory expenseCategoryUpdateDTOToEntity(ExpenseCategoryUpdateDTO dto);

    ExpenseCategoryUpdateDTO expenseCategoryUpdateEntityToDTO(ExpenseCategory expenseCategory);
}
