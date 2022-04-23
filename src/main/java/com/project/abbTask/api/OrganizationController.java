package com.project.abbTask.api;

import com.project.abbTask.model.dto.SignUpOrganizationDto;
import com.project.abbTask.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping("/sign/up")
    public ResponseEntity<Void> signUp(@RequestBody SignUpOrganizationDto request){
        organizationService.signUp(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
