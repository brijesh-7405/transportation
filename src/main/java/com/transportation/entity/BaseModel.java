package com.transportation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Embeddable
@MappedSuperclass
public class BaseModel {
    @Column(name = "created_date", insertable = true, updatable = false)
    private Date createdDate;
    @Column(name = "updated_date", insertable = true, updatable = true)
    private Date updatedDate;
    @PrePersist
    protected void onCreate() {
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = new Date();
    }
}
