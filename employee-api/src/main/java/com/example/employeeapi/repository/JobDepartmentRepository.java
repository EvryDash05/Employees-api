package com.example.employeeapi.repository;

import com.example.employeeapi.entity.JobDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDepartmentRepository extends JpaRepository<JobDepartmentEntity, String> {
}
