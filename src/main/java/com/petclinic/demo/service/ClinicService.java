package com.petclinic.demo.service;

import com.petclinic.demo.domain.Clinic;
import com.petclinic.demo.domain.User;

import java.util.List;

public interface ClinicService {

    void updateClinic(Clinic user);

    void saveClinic(Clinic user);

    Clinic getClinic(int id);

    List<Clinic> getClinicList();
}
