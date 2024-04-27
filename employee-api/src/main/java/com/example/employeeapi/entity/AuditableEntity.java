package com.example.employeeapi.entity;

import com.example.employeeapi.utils.Constants.DataBaseConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity implements Serializable {

    @CreatedBy
    @Column(name = DataBaseConstant.CREATE_USER, nullable = false, updatable = false)
    protected String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DataBaseConstant.CREATE_DATE, nullable = false, updatable = false)
    protected Date createDate;

    @LastModifiedBy
    @Column(name = DataBaseConstant.LAST_MODIFIED_USER, nullable = false)
    protected String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DataBaseConstant.LAST_MODIFIED_DATE, nullable = false)
    protected Date lastModifiedDate;

}
