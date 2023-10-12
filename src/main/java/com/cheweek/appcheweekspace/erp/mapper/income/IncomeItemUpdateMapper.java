package com.cheweek.appcheweekspace.erp.mapper.income;

import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeItemUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeItemUpdateMapper {

    IncomeItem incomeItemUpdateDTOToEntity(IncomeItemUpdateDTO dto);

    IncomeItemUpdateDTO incomeItemUpdateEntityToDTO(IncomeItem incomeItem);
}
