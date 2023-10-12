package com.cheweek.appcheweekspace.erp.mapper.expense;

import com.cheweek.appcheweekspace.erp.dto.info.expense.ExpenseItemCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.expense.ExpenseItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseItemCreateMapper {
    ExpenseItem expenseItemCreateDTOToEntity(ExpenseItemCreateDTO dto);

    ExpenseItemCreateDTO expenseItemCreateEntityToDTO(ExpenseItem expenseItem);
}
