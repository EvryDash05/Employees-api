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
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AuditTable(value = "tb_to_do_aud")
@Table(name = DataBaseConstant.TB_TODO)
@AuditOverride(forClass = AuditableEntity.class)
public class ToDoEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = DataBaseConstant.ID_TODO, nullable = false, length = 10, unique = true)
    private String toDoId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = FormatConstants.DATE_TIME_FORMAT)
    private Date startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = FormatConstants.DATE_TIME_FORMAT)
    private Date endDate;

    @Column(name = "complete")
    private boolean isComplete;

    /* RELATIONS */
    @ManyToOne
    @JoinColumn(name = DataBaseConstant.ID_EMPLOYEE, referencedColumnName = DataBaseConstant.ID_EMPLOYEE)
    private EmployeeEntity employee;

}
