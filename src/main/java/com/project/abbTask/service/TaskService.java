package com.project.abbTask.service;

import com.project.abbTask.model.dto.AddTaskDto;
import com.project.abbTask.model.dto.AssignTaskDto;
import com.project.abbTask.model.TaskListResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TaskService {

    void addTask(AddTaskDto request);

    void assignTask(AssignTaskDto request);

    TaskListResponse getTasks(UUID organizationId);

    TaskListResponse getCustomerTasks(UUID customerId);
}
