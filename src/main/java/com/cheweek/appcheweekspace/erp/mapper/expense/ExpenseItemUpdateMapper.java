package com.cheweek.appcheweekspace.erp.mapper.expense;


import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseCategoryUpdateDTO;
import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseItemUpdateMapper {

    ExpenseItem expenseItemUpdateDTOToEntity(ExpenseItemUpdateDTO dto);

    ExpenseCategoryUpdateDTO expenseItemUpdateEntityToDTO(ExpenseItem expenseItem);
}
