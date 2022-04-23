package com.project.abbTask.model;

import com.project.abbTask.model.enums.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String username;
    private String password;
    private String mail;
    private CustomerStatus status;


}
