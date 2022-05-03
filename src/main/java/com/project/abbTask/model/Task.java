package com.project.abbTask.model;

import com.project.abbTask.model.enums.TaskStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private TaskStatus status;
    private String name;
    private String description;
    private LocalDate deadline;

}
