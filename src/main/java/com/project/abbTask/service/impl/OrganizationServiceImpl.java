package com.project.abbTask.service.impl;

import com.project.abbTask.mapper.CustomerMapper;
import com.project.abbTask.mapper.OrganizationMapper;
import com.project.abbTask.model.dto.AddCustomerDto;
import com.project.abbTask.model.dto.AddOrganizationDto;
import com.project.abbTask.model.dto.SignUpOrganizationDto;
import com.project.abbTask.model.enums.CustomerStatus;
import com.project.abbTask.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final OrganizationMapper mapper;
    @Override
    public void signUp(SignUpOrganizationDto request) {
        UUID organizationId = UUID.randomUUID();
        AddOrganizationDto addOrganizationDto = AddOrganizationDto.builder()
                                                                            .name(request.getOrganizationName())
                                                                            .id(organizationId)
                                                                            .mail(request.getMail())
                                                                            .phoneNumber(request.getPhoneNumber())
                                                                            .build();
        AddCustomerDto addCustomerDto = AddCustomerDto.builder()
                                                                            .organizationId(organizationId)
                                                                            .mail(request.getMail())
                                                                            .status(CustomerStatus.ADMIN.name())
                                                                            .password(passwordEncoder.encode(request.getPassword()))
                                                                            .username(request.getUsername())
                                                                            .build();
        mapper.addOrganization(addOrganizationDto);
        customerMapper.addCustomer(addCustomerDto);
    }
}
