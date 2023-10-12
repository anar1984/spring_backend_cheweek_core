package com.cheweek.appcheweekspace.erp.mapper.income;

import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeAssignmentCreateDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeAssignment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeAssignmentCreateMapper {

    IncomeAssignment incomeAssignmentCreateDTOToEntity(IncomeAssignmentCreateDTO dto);

    IncomeAssignmentCreateDTO incomeAssignmentCreateEntityToDTO(IncomeAssignment incomeAssignment);
}
