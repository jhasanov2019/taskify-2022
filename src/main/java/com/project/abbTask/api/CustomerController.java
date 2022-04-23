package com.project.abbTask.api;

import com.project.abbTask.model.dto.AddCustomerDto;
import com.project.abbTask.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void>addCustomer(@RequestBody AddCustomerDto request){
        service.addCustomer(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
