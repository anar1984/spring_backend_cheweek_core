package com.cheweek.appcheweekspace.erp.mapper.hr;

import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeeCategoryDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.EmployeeCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeCategoryMapper {

    EmployeeCategory employeeCategoryDTOToEntity(EmployeeCategoryDTO dto);
    EmployeeCategoryDTO employeeCategoryEntityToDTO(EmployeeCategory category);

}
