package com.project.abbTask.model.dto;

import com.project.abbTask.model.enums.TaskStatus;
import liquibase.pro.packaged.B;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerTaskDto {
    private String username;
    private String description;
    private TaskStatus status;
    private Date deadline;
}
