package com.project.abbTask.mapstruct;

import com.project.abbTask.model.dto.TaskCustomerDto;
import com.project.abbTask.model.dto.TaskDto;
import com.project.abbTask.model.dto.TaskListResponseDto;
import com.project.abbTask.model.TaskCustomerResponse;
import com.project.abbTask.model.TaskListResponse;
import com.project.abbTask.model.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapstruct {

    @Mapping(target = "tasks", source = "dto.tasks")
    TaskListResponse map(TaskListResponseDto dto);

    @Mapping(target = "customers", source = "dto.customers")
    TaskResponse map(TaskDto dto);

    TaskCustomerResponse map(TaskCustomerDto dto);


}
