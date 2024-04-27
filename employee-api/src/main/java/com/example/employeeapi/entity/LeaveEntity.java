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
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AuditTable(value = "tb_leave_aud")
@Table(name = DataBaseConstant.TB_LEAVE)
@AuditOverride(forClass = AuditableEntity.class)
public class LeaveEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = DataBaseConstant.ID_LEAVE, nullable = false, length = 10, unique = true)
    private String leaveId;

    @DateTimeFormat(pattern = FormatConstants.DATE_TIME_FORMAT)
    @Column(name = "leave_date", nullable = false)
    private Date leaveDate;

    @Column(name = "reason", nullable = false, length = 200)
    private String reason;

    /* RELATIONS */
    @ManyToOne
    @JoinColumn(name = DataBaseConstant.ID_EMPLOYEE, referencedColumnName = DataBaseConstant.ID_EMPLOYEE)
    private EmployeeEntity employee;

}
