package com.project.abbTask.mapper;

import com.project.abbTask.model.dto.AddCustomerDto;
import com.project.abbTask.model.dto.CustomerDto;
import com.project.abbTask.model.Customer;
import liquibase.pro.packaged.P;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface CustomerMapper {

    void addCustomer(@Param("request") AddCustomerDto request);

    Optional <Customer> getCustomerByName(@Param("name") String name);

    List<CustomerDto> getAllCustomers(@Param("customerIds") List<UUID>customerIds);

    Optional<Customer> getCustomerByMail(@Param("name") String name);
}
