package com.fests.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by gatomulesei on 2/27/2017.
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Column(nullable = true)
    private String createdBy;

    @CreatedDate
    @Column(nullable = true)
    private Date createdDate;

    @LastModifiedBy
    @Column(nullable = true)
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(nullable = true)
    private Date lastModifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


}
