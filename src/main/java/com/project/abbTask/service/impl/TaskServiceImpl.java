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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskMapper mapper;
    private final CustomerMapper customerMapper;
    private final TaskMapstruct mapstruct;
    private final EmailSender emailSender;

    @Override
    public void addTask(AddTaskDto request) {
        if (mapper.getTaskByName(request.getName()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task already exist");
        }
        request.setStatus(TaskStatus.BACKLOG.name());
        mapper.addTask(request);
    }

    @Override
    @Transactional
    public void assignTask(AssignTaskDto request) {
        mapper.assignTask(request);
        List<CustomerDto>customers = customerMapper.getAllCustomers(request.getCustomerIds());
        customers
                .stream()
                .map(c->{
                    emailSender.sendMail(c.getMail(),"new task","task assigned");
                    return c;
                }).collect(Collectors.toList());


    }

    @Override
    public TaskListResponse getTasks(UUID organizationId) {
        return mapstruct.map(TaskListResponseDto.builder()
                                                          .tasks(mapper.getTask(organizationId))
                .build()
        );
    }

    @Override
    public TaskListResponse getCustomerTasks(UUID customerId) {
        return mapstruct.map(TaskListResponseDto.builder()
                                                          .tasks(mapper.getCustomerTasks(customerId))
                                                 .build()
        );
    }


}
