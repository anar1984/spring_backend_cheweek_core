package com.cheweek.spring_backend_cheweek_core.mapper;

import com.cheweek.spring_backend_cheweek_core.dto.PropertiesDTO;
import com.cheweek.spring_backend_cheweek_core.entity.PropertiesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertiesMapper {


    PropertiesEntity dtoToEntity (PropertiesDTO dto);
    PropertiesDTO entityToDto (PropertiesEntity dto);

}
