package com.cheweek.spring_backend_cheweek_core.mapper;

import com.cheweek.spring_backend_cheweek_core.dto.CorePropertiesDTO;
import com.cheweek.spring_backend_cheweek_core.entity.CoreProperties;
import com.cheweek.spring_backend_cheweek_core.entity.ProductType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CorePropertiesMapper {


    CoreProperties dtoToEntity (CorePropertiesDTO dto);
    CorePropertiesDTO entityToDto (CoreProperties dto);

}
