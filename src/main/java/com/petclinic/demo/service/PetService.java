package com.petclinic.demo.service;

import com.petclinic.demo.domain.Pet;

import java.util.List;

public interface PetService {


    void updatePet(Pet pet);

    void savePet(Pet pet);

    Pet getPet(int id);

    List<Pet> getPetList();
}
