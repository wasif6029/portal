package com.mist.portal.service;

import com.mist.portal.exception.custom.NotFoundException;
import com.mist.portal.mapper.StudentMapper;
import com.mist.portal.model.domain.Student;
import com.mist.portal.model.dto.StudentDto.CreateStudentRequest;
import com.mist.portal.model.dto.StudentDto.UpdateStudentRequest;
import com.mist.portal.persistance.entity.StudentEntity;
import com.mist.portal.persistance.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    public Page<Student> getAll(Pageable pageable){
        var entities = studentRepository.findAll(pageable);
        return entities.map(studentMapper::entityToDomain);
    }
    public Student getOne(UUID id){
        var entity = studentRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Student not Found"));
        return studentMapper.entityToDomain(entity);
    }
    public UUID createOne(CreateStudentRequest createRequest){
        var entity = new StudentEntity();
        entity.setId(UUID.randomUUID())
                .setName(createRequest.getName())
                .setRoll(createRequest.getRoll());
        var createdStudent = studentRepository.save(entity);
        return createdStudent.getId();
    }
    public void updateOne(UUID id, UpdateStudentRequest updateRequest){
        var entity = studentRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Student Not Found"));
        entity.setName(updateRequest.getName())
                .setRoll(updateRequest.getRoll());
        studentRepository.save(entity);
    }
    public void deleteOne(UUID id){
        studentRepository.deleteById(id);
    }

}
