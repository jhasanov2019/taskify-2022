package com.project.abbTask.service.impl;

import com.project.abbTask.config.EmailSender;
import com.project.abbTask.model.dto.AddCustomerDto;
import com.project.abbTask.mapper.CustomerMapper;
import com.project.abbTask.model.Customer;
import com.project.abbTask.model.enums.CustomerStatus;
import com.project.abbTask.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService, UserDetailsService {
    private final CustomerMapper mapper;
    private final PasswordEncoder passwordEncoder;

    private final EmailSender emailSender;

    @Override
    public void addCustomer(AddCustomerDto addCustomerDto) {
        addCustomerDto.setPassword(passwordEncoder.encode(addCustomerDto.getPassword()));
        addCustomerDto.setStatus(CustomerStatus.USER.name());
        mapper.addCustomer(addCustomerDto);
        emailSender.sendMail(addCustomerDto.getMail(), "user added","welcome");
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
       Customer customer = Optional.ofNullable(mapper.getCustomerByName(name)).orElseThrow(()-> new UsernameNotFoundException("user nor found"));
       Collection<SimpleGrantedAuthority>authorities = new ArrayList<>();
       authorities.add(new SimpleGrantedAuthority(customer.getStatus().name()));


       return new User(customer.getUsername(),customer.getPassword(),authorities);
    }

}
