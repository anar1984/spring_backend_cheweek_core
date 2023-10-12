package com.cheweek.appcheweekspace.erp.mapper.expense;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseCategoryCreateMapper {

    ExpenseCategory expenseCategoryCreateDTOToEntity(ExpenseCategoryCreateDTO dto);

    ExpenseCategoryCreateDTO expenseCategoryCreateEntityToDTO(ExpenseCategory expenseCategory);
}
