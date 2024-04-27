package com.example.employeeapi.entity;

import com.example.employeeapi.utils.Constants.DataBaseConstant;
import com.example.employeeapi.utils.Constants.FormatConstants;
import com.example.employeeapi.utils.enums.EGenre;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@AuditTable(value = "employee_aud")
@Table(name = DataBaseConstant.TB_EMPLOYEE)
@AuditOverride(forClass = AuditableEntity.class)
public class EmployeeEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId
    @Column(name = DataBaseConstant.ID_EMPLOYEE, nullable = false, length = 10, unique = true)
    private String employeeId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @DateTimeFormat(pattern = FormatConstants.DATE_TIME_FORMAT)
    private Date dateHire;

    @Email
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "quantity_task")
    private int quantityTask;

    @Column(name = "tasK_completed")
    private int completedTask;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    private EGenre genre;

    /* RELATIONS */
    @NotAudited
    @OneToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = DataBaseConstant.RELATION_EMPLOYEE_ROLE,
            joinColumns =  {@JoinColumn(name=DataBaseConstant.ID_EMPLOYEE)},
            inverseJoinColumns = {@JoinColumn(name=DataBaseConstant.ID_ROLE)}
    )
    @Column(name = DataBaseConstant.ID_ROLE, nullable = false)
    private Set<RoleEntity> roles;

    @OneToMany(mappedBy = "employee")
    private List<ToDoEntity> toDoList;

    @OneToMany(mappedBy = "employee")
    private List<LeaveEntity> leaveList;

    @OneToMany(mappedBy = "employee")
    private List<PayRollEntity> payRollList;

}
