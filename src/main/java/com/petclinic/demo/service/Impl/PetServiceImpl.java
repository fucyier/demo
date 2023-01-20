package com.petclinic.demo.service.Impl;

import com.petclinic.demo.domain.Pet;
import com.petclinic.demo.domain.User;
import com.petclinic.demo.repository.PetRepository;
import com.petclinic.demo.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
public class PetServiceImpl implements PetService {
    Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public void updatePet(Pet pet) {
        logger.info("PetServiceImpl/updatePet with pet={}", pet.toString());

    }

    @Override
    public void savePet(Pet pet) {
        logger.info("PetServiceImpl/updatePet with pet={}", pet.toString());
        petRepository.save(pet);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.READ_COMMITTED, readOnly = true)
    @Override
    public Pet getPet(int id) {
        logger.info("PetServiceImpl/getPet with id={}", id);
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isEmpty()) return null;
        return optionalPet.get();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.READ_COMMITTED, readOnly = true)
    @Override
    public List<Pet> getPetList() {
        logger.info("PetServiceImpl/getPetList");
        return petRepository.findAll();
    }
}
