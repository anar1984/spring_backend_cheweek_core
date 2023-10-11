package com.cheweek.spring_backend_cheweek_core.mapper.operation;

import com.cheweek.spring_backend_cheweek_core.dto.operation.TaskDto;
import com.cheweek.spring_backend_cheweek_core.entity.operation.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {
    TaskEntity taskEntityToTaskDto(@MappingTarget TaskEntity entity, TaskDto dto);
    TaskDto dtoToEntity(TaskEntity entity);

    TaskEntity dtoToEntity(TaskDto dto);
}
