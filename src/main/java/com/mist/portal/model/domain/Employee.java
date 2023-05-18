package com.mist.portal.model.domain;

import com.mist.portal.constant.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private UUID id;
    private String name;
    private EmployeeRole role;
    private EmployeeRole designation;
}
