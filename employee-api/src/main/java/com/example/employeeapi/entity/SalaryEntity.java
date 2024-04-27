package com.example.employeeapi.entity;

import com.example.employeeapi.utils.Constants.DataBaseConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditTable;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AuditTable(value = "tb_salary_aud")
@Table(name = DataBaseConstant.TB_SALARIES)
@AuditOverride(forClass = AuditableEntity.class)
public class SalaryEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = DataBaseConstant.ID_SALARY, nullable = false, length = 10, unique = true)
    private String salaryId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "annual", nullable = false)
    private BigDecimal amountAnnual;

    @Column(name = "bonus", nullable = false)
    private BigDecimal bonus;

    /* RELATIONS */
    @ManyToOne
    @JoinColumn(name = DataBaseConstant.ID_JOB_DEPARTMENT, referencedColumnName = DataBaseConstant.ID_JOB_DEPARTMENT)
    private JobDepartmentEntity department;

}