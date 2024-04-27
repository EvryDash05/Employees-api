package com.example.employeeapi.entity;

import com.example.employeeapi.utils.Constants.DataBaseConstant;
import com.example.employeeapi.utils.Constants.FormatConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditTable;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AuditTable(value = "tb_payroll_aud")
@Table(name = DataBaseConstant.TB_PAYMENTS)
@AuditOverride(forClass = AuditableEntity.class)
public class PayRollEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = DataBaseConstant.ID_PAYROLL, nullable = false, length = 10, unique = true)
    private String idPayRoll;

    @Column(name = "date", nullable = false)
    @DateTimeFormat(pattern = FormatConstants.DATE_TIME_FORMAT)
    private Date date;

    @Column(name = "report", nullable = false)
    private String report;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    /* RELATIONS */
    @ManyToOne
    @JoinColumn(name = DataBaseConstant.ID_EMPLOYEE, referencedColumnName = DataBaseConstant.ID_EMPLOYEE)
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = DataBaseConstant.ID_JOB_DEPARTMENT, referencedColumnName = DataBaseConstant.ID_JOB_DEPARTMENT)
    private JobDepartmentEntity department;

}
