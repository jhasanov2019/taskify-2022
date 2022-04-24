package com.project.abbTask.model.dto;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class AddCustomerDto {
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String status;
    @NonNull
    private UUID organizationId;
    @NonNull
    private String mail;
}
