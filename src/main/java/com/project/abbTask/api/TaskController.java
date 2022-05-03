package com.project.abbTask.api;

import com.project.abbTask.model.dto.AddTaskDto;
import com.project.abbTask.model.dto.AssignTaskDto;
import com.project.abbTask.model.TaskListResponse;
import com.project.abbTask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Void>addTask(@RequestBody AddTaskDto request){
        service.addTask(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/assign")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Void>assignTask(@RequestBody AssignTaskDto request){
        service.assignTask(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /***
     It would be more appropriate if users view the list of tasks within the organization they belong to
     ***/
    @GetMapping("/get/{organizationId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public TaskListResponse getTasks(@PathVariable("organizationId")UUID organizationId){
        return service.getTasks(organizationId);
    }

    @GetMapping("/getCustomerTasks/{customerId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public TaskListResponse getCustomerTasks(@PathVariable("customerId")UUID cutomerId){
        return service.getCustomerTasks(cutomerId);
    }

}
