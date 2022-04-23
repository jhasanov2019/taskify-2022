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
public class AddOrganizationDto {

    private UUID id;
    private String name;
    private String mail;
    private String phoneNumber;

}
