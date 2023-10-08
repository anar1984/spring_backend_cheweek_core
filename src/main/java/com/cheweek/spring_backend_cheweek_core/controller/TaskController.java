package com.cheweek.spring_backend_cheweek_core.controller;

import com.cheweek.spring_backend_cheweek_core.service.core.TaskCreateService;
import com.cheweek.spring_backend_cheweek_core.service.core.TaskDeletedService;
import com.cheweek.spring_backend_cheweek_core.service.core.TaskListService;
import com.cheweek.spring_backend_cheweek_core.service.core.TaskUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
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
    public ResponseEntity<?> createTask() {
        createService.createTask();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTask() {
        updateService.updateTask();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id) {
        deleteService.deleteTask(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
