package com.example.employeeapi.repository;

import com.example.employeeapi.entity.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, String> {
}
