package com.project.abbTask.model.dto;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskDto {
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private String status;
    private Date deadline;
}
