package com.mist.portal.model.dto.StudentDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class StudentResponse {
    private UUID id;
    private String name;
    private int roll;
}
