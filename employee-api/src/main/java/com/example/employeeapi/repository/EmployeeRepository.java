package com.example.employeeapi.repository;

import com.example.employeeapi.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
    Optional<EmployeeEntity> findByEmployeeId(String id);
    void deleteByEmployeeID(String id);
}
