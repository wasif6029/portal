package com.mist.portal.controller.rest;

import com.mist.portal.mapper.EmployeeMapper;
import com.mist.portal.model.dto.EmployeeDto.CreateEmployeeRequest;
import com.mist.portal.model.dto.EmployeeDto.EmployeeResponse;
import com.mist.portal.model.dto.EmployeeDto.UpdateEmployeeRequest;
import com.mist.portal.service.EmployeeService;
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
@RequestMapping(value = "api/Employees")
public class EmployeeRestController {
    private final EmployeeService EmployeeService;
    private final EmployeeMapper EmployeeMapper;

    @GetMapping
    public ResponseEntity<Page<EmployeeResponse>> getAll(Pageable pageable){
        var domains = EmployeeService.getAll(pageable);
        return ResponseEntity.ok(domains.map(EmployeeMapper::domainToResponse));
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponse> getOne(@PathVariable UUID id){
        var domain = EmployeeService.getOne(id);
        return ResponseEntity.ok(EmployeeMapper.domainToResponse(domain));
    }

    @PostMapping
    public ResponseEntity<Void> createOne(@RequestBody @Valid CreateEmployeeRequest createRequest){
        var id = EmployeeService.createOne(createRequest);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateOne(@PathVariable UUID id, @RequestBody @Valid UpdateEmployeeRequest updateRequest){
        EmployeeService.updateOne(id,updateRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID id){
        EmployeeService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }



}
