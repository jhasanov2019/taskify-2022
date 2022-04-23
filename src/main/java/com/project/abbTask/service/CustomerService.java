package com.project.abbTask.service;

import com.project.abbTask.model.dto.AddCustomerDto;
import org.springframework.stereotype.Service;


@Service
public interface CustomerService {

    void addCustomer(AddCustomerDto addCustomerDto);

}
