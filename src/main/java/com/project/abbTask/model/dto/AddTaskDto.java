package com.project.abbTask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskDto {

    private String name;
    private String description;
    private String status;
    private Date deadline;

}
