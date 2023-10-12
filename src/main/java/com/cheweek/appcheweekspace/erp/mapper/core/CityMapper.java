package com.cheweek.appcheweekspace.erp.mapper.core;

import com.cheweek.appcheweekspace.erp.dto.core.CityDTO;
import com.cheweek.appcheweekspace.erp.entity.core.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City cityDTOToEntity(CityDTO dto);
    CityDTO cityEntityToDTO(City city);
}
