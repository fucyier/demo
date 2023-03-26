package com.petclinic.demo.service.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.petclinic.demo.domain.Clinic;
import com.petclinic.demo.repository.ClinicRepository;
import com.petclinic.demo.service.ClinicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
public class ClinicServiceImpl implements ClinicService {
    Logger logger = LoggerFactory.getLogger(ClinicServiceImpl.class);
    private final ClinicRepository clinicRepository;

    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public void updateClinic(Clinic clinic) {
        logger.info("UserServiceImpl/updateUser with user={}", clinic.toString());
    }

    @Override
    public void saveClinic(Clinic clinic) {
        logger.info("UserServiceImpl/saveUser with user={}", clinic.toString());
        clinicRepository.save(clinic);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public Clinic getClinic(int id) {
        logger.info("UserServiceImpl/getUser with id={}", id);
        Optional<Clinic> optionalUser = clinicRepository.findById(id);
        if (optionalUser.isEmpty()) return null;
        return optionalUser.get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.READ_COMMITTED, readOnly = true)
    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public List<Clinic> getClinicList() {
        logger.info("UserServiceImpl/getUserList");

        return clinicRepository.findAll();
    }

    private List<Clinic> defaultGreeting() {
        List<Clinic> clinicList = new ArrayList<>();
        return clinicList;
    }
}
