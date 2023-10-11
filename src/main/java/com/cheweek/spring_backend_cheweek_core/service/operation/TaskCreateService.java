package com.cheweek.spring_backend_cheweek_core.service.operation;

import com.cheweek.spring_backend_cheweek_core.dto.operation.ResponseTaskCreate;
import com.cheweek.spring_backend_cheweek_core.dto.operation.TaskDto;
import com.cheweek.spring_backend_cheweek_core.entity.operation.RequestEntity;
import com.cheweek.spring_backend_cheweek_core.entity.operation.TaskEntity;
import com.cheweek.spring_backend_cheweek_core.entity.operation.TaskTypeEntity;
import com.cheweek.spring_backend_cheweek_core.mapper.operation.TaskMapper;
import com.cheweek.spring_backend_cheweek_core.repository.operation.RequestEntityRepository;
import com.cheweek.spring_backend_cheweek_core.repository.operation.TaskEntityRepository;
import com.cheweek.spring_backend_cheweek_core.repository.operation.TaskTypeEntityRepository;
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
