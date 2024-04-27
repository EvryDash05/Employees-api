package com.example.employeeapi.repository;

import com.example.employeeapi.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, String> {
}
