package com.petclinic.demo.controller;

import com.petclinic.demo.domain.Clinic;
import com.petclinic.demo.domain.User;
import com.petclinic.demo.service.ClinicService;
import com.petclinic.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/get-list")
    ResponseEntity<List<Clinic>> clinicList() {
        List<Clinic> userList = clinicService.getClinicList();
        return ResponseEntity.ok(userList);
    }
    // end::get-aggregate-root[]

    @PostMapping("/")
    ResponseEntity saveClinic(@RequestBody Clinic clinic) {
        clinicService.saveClinic(clinic);
        return ResponseEntity.ok("Saved successfully");
    }

    @PutMapping("/")
    ResponseEntity updateClinic(@RequestBody Clinic clinic) {
        clinicService.updateClinic(clinic);
        return ResponseEntity.ok("Updated successfully");
    }

    // Single item

    @GetMapping("/{id}")
    ResponseEntity<Clinic> getClinic(@PathVariable int id) {

        return ResponseEntity.ok(clinicService.getClinic(id));
    }
}
