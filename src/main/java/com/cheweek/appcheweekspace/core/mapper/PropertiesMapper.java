package com.cheweek.appcheweekspace.core.mapper;

import com.cheweek.appcheweekspace.core.dto.PropertiesDTO;
import com.cheweek.appcheweekspace.core.entity.info.PropertiesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertiesMapper {


    PropertiesEntity dtoToEntity (PropertiesDTO dto);
    PropertiesDTO entityToDto (PropertiesEntity dto);

}
