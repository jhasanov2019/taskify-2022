package com.project.abbTask.mapper;

import com.project.abbTask.model.dto.AddCustomerDto;
import com.project.abbTask.model.dto.CustomerDto;
import com.project.abbTask.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CustomerMapper {

    void addCustomer(@Param("request") AddCustomerDto request);

   Optional <Customer> getCustomerByName(@Param("name") String name);


    List<CustomerDto> getAllCustomers();

    Optional<Customer> getCustomerByMail(String name);
}
