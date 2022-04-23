package com.project.abbTask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpOrganizationDto {

    private String organizationName;
    private String phoneNumber;
    private String mail;
    private String address;
    private String username;
    private String password;

}
