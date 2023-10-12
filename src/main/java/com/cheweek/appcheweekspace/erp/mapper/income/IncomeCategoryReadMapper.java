package com.cheweek.appcheweekspace.erp.mapper.income;


import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeCategoryReadDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeCategoryReadMapper {

    IncomeCategory incomeCategoryReadDTOToEntity(IncomeCategoryReadDTO dto);

    IncomeCategoryReadDTO incomeCategoryReadEntityToDTO(IncomeCategory incomeCategory);
}
