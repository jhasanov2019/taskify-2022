package com.project.abbTask.model.dto;

import com.project.abbTask.model.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCustomerDto {
    private String username;
    private String password;
    private String status;
    private UUID organizationId;
    private String mail;
}
