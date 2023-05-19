package com.mist.portal.controller.rest;

import com.mist.portal.mapper.StudentMapper;
import com.mist.portal.model.dto.StudentDto.CreateStudentRequest;
import com.mist.portal.model.dto.StudentDto.StudentResponse;
import com.mist.portal.model.dto.StudentDto.UpdateStudentRequest;
import com.mist.portal.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/students")
public class StudentRestController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(Pageable pageable){
        var domains = studentService.getAll(pageable);
        return ResponseEntity.ok(domains.map(studentMapper::domainToResponse));
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponse> getOne(@PathVariable UUID id){
        var domain = studentService.getOne(id);
        return ResponseEntity.ok(studentMapper.domainToResponse(domain));
    }

    @PostMapping
    public ResponseEntity<Void> createOne(@RequestBody @Valid CreateStudentRequest createRequest){
        var id = studentService.createOne(createRequest);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateOne(@PathVariable UUID id, @RequestBody @Valid UpdateStudentRequest updateRequest){
        studentService.updateOne(id,updateRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID id){
        studentService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }



}
