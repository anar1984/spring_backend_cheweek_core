package com.cheweek.spring_backend_cheweek_core.controller.operation;

import com.cheweek.spring_backend_cheweek_core.dto.core.GetObjectById;
import com.cheweek.spring_backend_cheweek_core.dto.operation.TaskDto;
import com.cheweek.spring_backend_cheweek_core.service.operation.TaskCreateService;
import com.cheweek.spring_backend_cheweek_core.service.operation.TaskDeletedService;
import com.cheweek.spring_backend_cheweek_core.service.operation.TaskListService;
import com.cheweek.spring_backend_cheweek_core.service.operation.TaskUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operation/task")
@Validated
public class TaskController {
    private final TaskCreateService createService;
    private final TaskUpdateService updateService;
    private final TaskListService listService;
    private final TaskDeletedService deleteService;

    @PostMapping("/get")
    public ResponseEntity<?> getTask() {
        return listService.getTask();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody @Valid TaskDto dto) {
        return  ResponseEntity.ok(createService.createTask(dto));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTask() {
        updateService.updateTask();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteTask(@RequestBody @Valid GetObjectById id) {
//        deleteService.deleteTask(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
