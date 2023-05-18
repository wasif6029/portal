package com.mist.portal.model.dto.EmployeeDto;

import com.mist.portal.constant.EmployeeRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class UpdateEmployeeRequest {
    private String name;
    private EmployeeRole role;
    private String designation;
}
