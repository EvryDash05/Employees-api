package com.example.employeeapi.service;

import com.example.employeeapi.entity.EmployeeEntity;
import com.example.employeeapi.models.request.EmployeeRequest;
import com.example.employeeapi.models.response.EmployeeResponse;

import java.util.Optional;

public interface EmployeeService {
    public EmployeeResponse save(EmployeeRequest request);
    public Optional<EmployeeResponse> searchById(String id);
    public EmployeeResponse updateEmployee(EmployeeRequest request, String id);
    public void deleteEmployeeById(String id);
}
