package com.example.employeeapi.bussines;

import com.example.employeeapi.entity.EmployeeEntity;
import com.example.employeeapi.models.request.EmployeeRequest;
import com.example.employeeapi.models.response.EmployeeResponse;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeBussines implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse save(EmployeeRequest request) {
        return null;
    }

    @Override
    public Optional<EmployeeResponse> searchById(String id) {
        return Optional.empty();
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest request, String id) {
        return null;
    }

    @Override
    public void deleteEmployeeById(String id) {

    }

    /* → MAPPERS ← */
    private EmployeeResponse toEmployeeResponse(EmployeeEntity employee) {
        return new ModelMapper().map(employee, EmployeeResponse.class);
    }

    private EmployeeEntity toEmployeeEntity(EmployeeRequest request) {
        return new ModelMapper().map(request, EmployeeEntity.class);
    }

}
