package com.mist.portal.model.dto.EmployeeDto;

import com.mist.portal.constant.EmployeeRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class EmployeeResponse {
    private UUID id;
    private EmployeeRole role;
    private String name;
    private String designation;
}
