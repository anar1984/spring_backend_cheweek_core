package com.cheweek.appcheweekspace.erp.mapper.hr;

import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeePrivateInfoCreateUpdateDTO;
import com.cheweek.appcheweekspace.erp.dto.info.hr.EmployeePrivateInfoReadInfoDTO;
import com.cheweek.appcheweekspace.erp.entity.info.hr.EmployeePrivateInfo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeePrivateInfoMapper {
    EmployeePrivateInfo employeePrivateInfoReadInfoDTOToEntity(EmployeePrivateInfoReadInfoDTO dto);
    EmployeePrivateInfoReadInfoDTO employeePrivateInfoReadInfoEntityToDTO(EmployeePrivateInfo privateInfo);

    @Mapping(target = "mobile", source = "dto.mobile")
    EmployeePrivateInfo employeePrivateInfoCreateDTOToEntity(EmployeePrivateInfoCreateUpdateDTO dto);
    EmployeePrivateInfoCreateUpdateDTO employeePrivateInfoCreateEntityToDTO(EmployeePrivateInfo privateInfo);

    EmployeePrivateInfo employeePrivateInfoUpdateDTOToEntity(@MappingTarget EmployeePrivateInfo entity, EmployeePrivateInfoCreateUpdateDTO dto);
}

