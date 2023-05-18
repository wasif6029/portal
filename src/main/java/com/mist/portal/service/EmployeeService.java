package com.mist.portal.service;

import com.mist.portal.exception.custom.NotFoundException;
import com.mist.portal.mapper.EmployeeMapper;
import com.mist.portal.model.domain.Employee;
import com.mist.portal.model.dto.EmployeeDto.CreateEmployeeRequest;
import com.mist.portal.model.dto.EmployeeDto.UpdateEmployeeRequest;
import com.mist.portal.persistance.entity.EmployeeEntity;
import com.mist.portal.persistance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository EmployeeRepository;
    private final EmployeeMapper EmployeeMapper;
    public Page<Employee> getAll(Pageable pageable){
        var entities = EmployeeRepository.findAll(pageable);
        return entities.map(EmployeeMapper::entityToDomain);
    }
    public Employee getOne(UUID id){
        var entity = EmployeeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Employee not Found"));
        return EmployeeMapper.entityToDomain(entity);
    }
    public UUID createOne(CreateEmployeeRequest createRequest){
        var entity = new EmployeeEntity();
        entity.setId(UUID.randomUUID())
                .setName(createRequest.getName())
                .setDesignation(createRequest.getDesignation())
                .setRole(createRequest.getRole());

        var createdEmployee = EmployeeRepository.save(entity);
        return createdEmployee.getId();
    }
    public void updateOne(UUID id, UpdateEmployeeRequest updateRequest){
        var entity = EmployeeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Employee Not Found"));
        entity.setName(updateRequest.getName())
                .setDesignation(updateRequest.getDesignation())
                .setRole(updateRequest.getRole());
        EmployeeRepository.save(entity);
    }
    public void deleteOne(UUID id){
        EmployeeRepository.deleteById(id);
    }

}
