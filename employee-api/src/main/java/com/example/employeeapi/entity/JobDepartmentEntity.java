package com.example.employeeapi.entity;

import com.example.employeeapi.utils.Constants.DataBaseConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditTable;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AuditTable(value = "tb_job_department_aud")
@Table(name = DataBaseConstant.TB_JOB_DEPARTMENT)
@AuditOverride(forClass = AuditableEntity.class)
public class JobDepartmentEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = DataBaseConstant.ID_JOB_DEPARTMENT, nullable = false, length = 10, unique = true)
    private String idJobDepartment;

    @Column(name = "job_department_name", nullable = false, length = 30)
    private String name;

    @Column(name = "department_description", nullable = false, length = 200)
    private String description;

    @Column(name = "quantity_employees", nullable = false)
    private int quantityEmployees;

    /* RELATIONS */
    @OneToMany(mappedBy = "department")
    private List<SalaryEntity> salaryList;

    @OneToMany(mappedBy = "department")
    private List<PayRollEntity> payrollList;

}
