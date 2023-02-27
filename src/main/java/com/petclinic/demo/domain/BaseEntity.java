package com.petclinic.demo.domain;

import com.petclinic.demo.listener.BaseEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public abstract class BaseEntity extends BaseId implements Serializable {
    @Column(name = "createdTime")
    private LocalDateTime createdTime;
    @Column(name = "created")
    private Integer created;

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}
