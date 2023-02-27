package com.petclinic.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(schema = "petclinic", name = "Clinic")
public class Clinic extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinicId")
    private Integer clinicId;
    @Column(name = "Name")
    private String name;

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "clinicId=" + clinicId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
