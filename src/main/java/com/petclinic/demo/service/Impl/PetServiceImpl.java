package com.petclinic.demo.service.Impl;

import com.petclinic.demo.domain.Pet;
import com.petclinic.demo.repository.PetRepository;
import com.petclinic.demo.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public void updatePet(Pet pet) {

    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public Pet getPet(int id) {
        return null;
    }

    @Override
    public List<Pet> getPetList() {
        return null;
    }
}
