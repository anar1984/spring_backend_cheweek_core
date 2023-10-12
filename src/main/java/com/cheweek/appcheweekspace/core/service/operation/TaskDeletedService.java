package com.cheweek.appcheweekspace.core.service.operation;

import com.cheweek.appcheweekspace.utility.SessionManager;
import com.cheweek.appcheweekspace.core.entity.operation.TaskEntity;
import com.cheweek.appcheweekspace.core.exception.operation.TaskNotFoundException;
import com.cheweek.appcheweekspace.core.repository.operation.TaskEntityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDeletedService {
    final SessionManager manager;
    final TaskEntityRepository taskRepository;
    public void deleteTask(String id){
        TaskEntity task = taskRepository.findById(id).orElseThrow(()-> {
            TaskNotFoundException taskNotFoundException = new TaskNotFoundException();
            throw taskNotFoundException;

        });// "Task not found"
        task.setStatus("D");
        taskRepository.save(task);

    }
}
