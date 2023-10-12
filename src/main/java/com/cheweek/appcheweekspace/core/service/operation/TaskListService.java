package com.cheweek.appcheweekspace.core.service.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskListService {

    public ResponseEntity<?>getTask(){
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
