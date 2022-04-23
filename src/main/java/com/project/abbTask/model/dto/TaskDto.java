package com.project.abbTask.model.dto;

import com.project.abbTask.model.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private TaskStatus status;
    private String name;
    private String description;
    private LocalDate deadline;
    private List<TaskCustomerDto> customers;
}
