package com.project.abbTask.mapper;

import com.project.abbTask.model.Task;
import com.project.abbTask.model.dto.AddTaskDto;
import com.project.abbTask.model.dto.AssignTaskDto;
import com.project.abbTask.model.dto.TaskDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface TaskMapper {

    void addTask(@Param("request") AddTaskDto request);

    void assignTask(@Param("request") AssignTaskDto request);

    List<TaskDto> getTask(@Param("organizationId") UUID organizationId);

    Optional<Task> getTaskByName(@Param("name") String name);

    List<TaskDto> getCustomerTasks(@Param("customerId") UUID customerId);
}
