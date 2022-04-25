package com.project.abbTask;

import com.project.abbTask.mapper.CustomerMapper;
import com.project.abbTask.model.Customer;
import com.project.abbTask.model.dto.AddCustomerDto;
import com.project.abbTask.model.enums.CustomerStatus;
import com.project.abbTask.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {


    @Test
    @DisplayName("register customer success")
    public void addCustomerTest(){
        CustomerService customerService = mock(CustomerService.class);

        AddCustomerDto customer = AddCustomerDto.builder()
                .username("James")
                .password("root")
                .mail("james96@gmail.com")
                .organizationId(UUID.fromString("0e73038b-b0fb-4990-a379-dd5c172e25d9"))
                .status("USER")
                .build();

        doNothing().when(customerService).addCustomer(customer);

        customerService.addCustomer(customer);

        verify(customerService,times(1)).addCustomer(customer);
    }



}
