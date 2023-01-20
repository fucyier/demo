package com.petclinic.demo.controller;

import com.petclinic.demo.domain.Pet;
import com.petclinic.demo.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/get-list")
    ResponseEntity<List<Pet>> petList() {
        List<Pet> petList = petService.getPetList();
        return ResponseEntity.ok(petList);
    }
    // end::get-aggregate-root[]

    @PostMapping("/")
    ResponseEntity savePet(@RequestBody Pet pet) {
        petService.savePet(pet);
        return ResponseEntity.ok("Saved successfully");
    }

    @PutMapping("/")
    ResponseEntity updatePet(@RequestBody Pet pet) {
        petService.updatePet(pet);
        return ResponseEntity.ok("Updated successfully");
    }

    // Single item

    @GetMapping("/{id}")
    ResponseEntity<Pet> getPet(@PathVariable int id) {

        return ResponseEntity.ok(petService.getPet(id));
    }
}
