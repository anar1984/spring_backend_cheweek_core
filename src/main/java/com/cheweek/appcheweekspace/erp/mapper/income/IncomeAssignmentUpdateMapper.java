package com.cheweek.appcheweekspace.erp.mapper.income;

import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeAssignmentUpdateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeAssignment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeAssignmentUpdateMapper {

    IncomeAssignment incomeAssignmentUpdateDTOToEntity(IncomeAssignmentUpdateDTO dto);

    IncomeAssignmentUpdateDTO incomeAssignmentUpdateEntityToDTO(IncomeAssignment incomeAssignment);
}
