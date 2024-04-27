package com.example.employeeapi.repository;

import com.example.employeeapi.entity.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, String> {
}
