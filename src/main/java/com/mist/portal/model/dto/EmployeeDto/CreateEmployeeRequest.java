package com.mist.portal.model.dto.EmployeeDto;

import com.mist.portal.constant.EmployeeRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CreateEmployeeRequest {
    private String name;
    private EmployeeRole role;
    private String designation;
}
