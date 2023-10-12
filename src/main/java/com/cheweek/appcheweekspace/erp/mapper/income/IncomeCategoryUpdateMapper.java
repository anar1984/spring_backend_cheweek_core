package com.cheweek.appcheweekspace.erp.mapper.income;


import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeCategoryUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeCategory;
import org.mapstruct.Mapper;

@Mapper
public interface IncomeCategoryUpdateMapper {
    IncomeCategory incomeCategoryUpdateDTOToEntity(IncomeCategoryUpdateDTO dto);

    IncomeCategoryUpdateDTO incomeCategoryUpdateEntityToDTO(IncomeCategory incomeCategory);
}
