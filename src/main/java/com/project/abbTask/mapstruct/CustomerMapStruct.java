package com.project.abbTask.mapstruct;

import com.project.abbTask.model.Customer;
import com.project.abbTask.model.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapStruct {
    Customer map(CustomerDto dto);
}
