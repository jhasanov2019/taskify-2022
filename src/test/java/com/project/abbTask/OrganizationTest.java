package com.project.abbTask;


import com.project.abbTask.model.dto.SignUpOrganizationDto;
import com.project.abbTask.service.OrganizationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OrganizationTest {

    @Test
    @DisplayName("sign up success")
    public void signUpTest(){
        OrganizationService organizationService = mock(OrganizationService.class);
        SignUpOrganizationDto signUpRequest = SignUpOrganizationDto.builder()
                                                                            .address("address-1")
                                                                            .organizationName("name-1")
                                                                            .password("root")
                                                                            .phoneNumber("+994556935092")
                                                                            .mail("jhasanov2019@gmail.com")
                                                                            .username("username-1")
                                                                    .build();

        doNothing().when(organizationService).signUp(signUpRequest);
        organizationService.signUp(signUpRequest);
        verify(organizationService,times(1)).signUp(signUpRequest);

    }
}
