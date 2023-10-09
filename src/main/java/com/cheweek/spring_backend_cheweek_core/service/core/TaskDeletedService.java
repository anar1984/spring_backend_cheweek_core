package com.cheweek.spring_backend_cheweek_core.service.core;

import com.cheweek.spring_backend_cheweek_core.entity.TaskEntity;
import com.cheweek.spring_backend_cheweek_core.exception.TaskNotFoundException;
import com.cheweek.spring_backend_cheweek_core.repository.TaskEntityRepository;
import com.cheweek.spring_backend_cheweek_core.utility.SessionManager;
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
