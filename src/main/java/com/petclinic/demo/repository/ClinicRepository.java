package com.petclinic.demo.repository;

import com.petclinic.demo.domain.Clinic;
import com.petclinic.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
}
