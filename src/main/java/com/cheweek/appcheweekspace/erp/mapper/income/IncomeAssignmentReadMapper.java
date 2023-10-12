package com.cheweek.appcheweekspace.erp.mapper.income;

import com.cheweek.appcheweekspace.erp.dto.info.income.IncomeAssignmentReadDTO;
import com.cheweek.appcheweekspace.erp.entity.info.income.IncomeAssignment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeAssignmentReadMapper {

    IncomeAssignment incomeAssignmentReadDTOToEntity(IncomeAssignmentReadDTO dto);

    IncomeAssignmentReadDTO incomeAssignmentReadEntityToDTO(IncomeAssignment incomeAssignment);
}
