package com.cheweek.appcheweekspace.erp.mapper.income;

import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeItemCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeItemCreateMapper {

    IncomeItem incomeItemCreateDTOToEntity(IncomeItemCreateDTO dto);

    IncomeItemCreateDTO incomeItemCreateEntityToDTO(IncomeItem incomeItem);
}
