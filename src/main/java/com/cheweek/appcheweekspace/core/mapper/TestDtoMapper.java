package com.cheweek.appcheweekspace.core.mapper;

import com.cheweek.appcheweekspace.core.projection.TestMyProjection;
import com.cheweek.appcheweekspace.core.dto.TestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestDtoMapper {
    public TestDto testMyProjectionToTestDto(TestMyProjection testMyProjection);

}
