package com.example.employeeapi.repository;

import com.example.employeeapi.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    Optional<RoleEntity> findByRoleId(String roleId);
    void deleteByRoleId(String roleId);
}