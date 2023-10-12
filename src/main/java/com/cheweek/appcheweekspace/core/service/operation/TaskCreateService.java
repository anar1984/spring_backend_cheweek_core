package com.cheweek.appcheweekspace.core.service.operation;

import com.cheweek.appcheweekspace.core.dto.operation.ResponseTaskCreate;
import com.cheweek.appcheweekspace.core.dto.operation.TaskDto;
import com.cheweek.appcheweekspace.core.entity.operation.TaskEntity;
import com.cheweek.appcheweekspace.core.mapper.operation.TaskMapper;
import com.cheweek.appcheweekspace.core.repository.operation.RequestEntityRepository;
import com.cheweek.appcheweekspace.core.repository.operation.TaskEntityRepository;
import com.cheweek.appcheweekspace.core.repository.operation.TaskTypeEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskCreateService {
    private final TaskMapper taskMapper;
    private final TaskEntityRepository taskEntityRepository;
    private final RequestEntityRepository requestEntity;
    private final TaskTypeEntityRepository taskTypeEntity;

    public ResponseTaskCreate createTask(TaskDto dto){
     ResponseTaskCreate create = new ResponseTaskCreate();
     if(requestEntity.existsById(dto.getFkRequestId())) throw new RuntimeException();
     if(taskTypeEntity.existsByTaskTypeKey(dto.getFkTaskTypeKey())) throw new RuntimeException();
        TaskEntity entity = taskMapper.dtoToEntity(dto);

     return create;
    }

}
