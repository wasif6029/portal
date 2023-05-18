package com.mist.portal.mapper;

import com.mist.portal.model.domain.Student;
import com.mist.portal.model.dto.StudentDto.StudentResponse;
import com.mist.portal.persistance.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student entityToDomain(StudentEntity entity);
    StudentResponse domainToResponse(Student student);
}
