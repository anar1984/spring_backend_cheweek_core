package com.cheweek.appcheweekspace.erp.mapper.expense;


import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemReadDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseItemReadMapper {

    ExpenseItem expenseItemReadDTOToEntity(ExpenseItemReadDTO dto);

    ExpenseItemReadDTO expenseItemReadEntityToDTO(ExpenseItem expenseItem);
}
