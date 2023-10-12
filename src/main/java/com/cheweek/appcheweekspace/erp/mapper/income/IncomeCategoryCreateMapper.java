package com.cheweek.appcheweekspace.erp.mapper.income;

import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeCategoryCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeCategoryCreateMapper {

    IncomeCategory incomeCategoryCreateDTOToEntity(IncomeCategoryCreateDTO dto);

    IncomeCategoryCreateDTO incomeCategoryCreateEntityToDTO(IncomeCategory incomeCategory);

}
