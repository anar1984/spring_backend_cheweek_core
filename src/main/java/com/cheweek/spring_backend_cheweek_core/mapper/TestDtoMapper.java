package com.cheweek.spring_backend_cheweek_core.mapper;

import com.cheweek.spring_backend_cheweek_core.dto.TestDto;
import com.cheweek.spring_backend_cheweek_core.projection.TestMyProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestDtoMapper {
    public TestDto testMyProjectionToTestDto(TestMyProjection testMyProjection);

}
