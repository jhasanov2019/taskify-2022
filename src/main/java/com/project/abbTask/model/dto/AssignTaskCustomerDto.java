package com.project.abbTask.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AssignTaskCustomerDto {

    private UUID id;
    private String customerMail;

}
