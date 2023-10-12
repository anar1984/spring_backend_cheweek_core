package com.cheweek.appcheweekspace.erp.mapper.income;


import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeItemReadDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeItemReadMapper {

    IncomeItem incomeItemReadDTOToEntity(IncomeItemReadDTO dto);

    IncomeItemReadDTO incomeItemReadEntityToDTO(IncomeItem incomeItem);
}
