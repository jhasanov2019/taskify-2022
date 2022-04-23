package com.project.abbTask.service;

import com.project.abbTask.model.dto.SignUpOrganizationDto;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {
    void signUp(SignUpOrganizationDto request);
}
