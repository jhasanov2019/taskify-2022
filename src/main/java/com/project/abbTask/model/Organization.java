package com.project.abbTask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    private String name;
    private String mail;
    private String phoneNumber;
    private String address;
    private List<Customer>customers;

}
