package com.mist.portal.mapper;

import com.mist.portal.model.domain.Employee;
import com.mist.portal.model.dto.EmployeeDto.EmployeeResponse;
import com.mist.portal.persistance.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee entityToDomain(EmployeeEntity entity);
    EmployeeResponse domainToResponse(Employee employee);
}
