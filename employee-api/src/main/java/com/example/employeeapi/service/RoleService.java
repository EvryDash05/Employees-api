package com.example.employeeapi.service;

import com.example.employeeapi.models.request.RoleRequest;
import com.example.employeeapi.models.response.RoleResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    public RoleResponse save(RoleRequest request);
    public List<RoleResponse> getRoles(Pageable pageable);
    public RoleResponse searchById(String id);
    public RoleResponse updateRole(String name, String id);
    public void deleteRoleById(String id);
}
