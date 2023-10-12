package com.cheweek.appcheweekspace.erp.mapper.core;

import com.cheweek.appcheweekspace.erp.dto.core.CountryDTO;
import com.cheweek.appcheweekspace.erp.entity.core.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country countryDTOToEntity(CountryDTO dto);
    CountryDTO countryEntityToDTO(Country country);
}
