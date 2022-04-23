package com.project.abbTask.mapper;

import com.project.abbTask.model.dto.AddOrganizationDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrganizationMapper {
    void addOrganization(@Param("request") AddOrganizationDto request);

}
