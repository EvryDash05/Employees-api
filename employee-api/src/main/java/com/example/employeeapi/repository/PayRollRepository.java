package com.example.employeeapi.repository;

import com.example.employeeapi.entity.PayRollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRollRepository extends JpaRepository<PayRollEntity, String> {
}
