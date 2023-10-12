package com.cheweek.appcheweekspace.erp.mapper.hr;

import com.cheweek.appcheweekspace.erp.dto.info.hr.*;
import com.cheweek.appcheweekspace.erp.entity.info.hr.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface EmployeeMapper {


    @Mapping(target = "firstName", source = "dto.firstName")
    Employee employeeCreateDTOToEntity(EmployeeCreateDTO dto);
    EmployeeCreateDTO employeeCreateEntityToDTO(Employee employee);

    Employee employeeFilterDTOToEntity(EmployeeFilterDTO dto);
    EmployeeFilterDTO employeeFilterEntityToDTO(Employee employee);

    Employee employeeReadInfoDTOToEntity(EmployeeReadInfoDTO dto);
    EmployeeReadInfoDTO employeeReadInfoEntityToDTO(Employee employee);

    Employee employeeReadDTOToEntity(EmployeeReadDTO dto);
    EmployeeReadDTO employeeReadEntityToDTO(Employee employee);

    Employee employeeUpdateDTOToEntity(@MappingTarget Employee employee, EmployeeUpdateDTO dto);
}
