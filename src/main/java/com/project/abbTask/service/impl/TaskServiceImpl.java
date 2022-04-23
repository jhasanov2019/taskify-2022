package com.project.abbTask.service.impl;

import com.project.abbTask.config.EmailSender;
import com.project.abbTask.mapper.CustomerMapper;
import com.project.abbTask.mapper.TaskMapper;
import com.project.abbTask.mapstruct.TaskMapstruct;
import com.project.abbTask.model.TaskListResponse;
import com.project.abbTask.model.dto.AddTaskDto;
import com.project.abbTask.model.dto.AssignTaskDto;
import com.project.abbTask.model.dto.CustomerDto;
import com.project.abbTask.model.dto.TaskListResponseDto;
import com.project.abbTask.model.enums.TaskStatus;
import com.project.abbTask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskMapper mapper;
    private final CustomerMapper customerMapper;
    private final TaskMapstruct mapstruct;
    private final EmailSender emailSender;

    @Override
    public void addTask(AddTaskDto request) {
        request.setStatus(TaskStatus.BACKLOG.name());
        mapper.addTask(request);
    }

    @Override
    public void assignTask(AssignTaskDto request) {
        mapper.assignTask(request);
        List<CustomerDto>customers = customerMapper.getAllCustomers();
        for (CustomerDto customer:customers){
            for (UUID customerId:request.getCustomerIds()){
                if (customerId.equals(customer.getId())) {
                    emailSender.sendMail(customer.getMail(), request.getTaskName(), request.getTaskDescription());
                }
            }
        }
    }

    @Override
    public TaskListResponse getTasks(UUID organizationId) {
        return mapstruct.map(TaskListResponseDto.builder().tasks(mapper.getTask(organizationId)).build());
    }




}
