package com.example.employeeapi.entity;

import com.example.employeeapi.utils.Constants.DataBaseConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = DataBaseConstant.TB_ROLE)
@EntityListeners(AuditableEntity.class)
@AuditOverride(forClass = AuditableEntity.class)
public class RoleEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = "role_id", nullable = false, length = 10, unique = true)
    private String roleId;

    @Column(name = "role_name", nullable = false, length = 20)
    private String name;

    /* RELATIONS */
    @OneToMany(mappedBy = "roles")
    private Set<EmployeeEntity> employees;

}
