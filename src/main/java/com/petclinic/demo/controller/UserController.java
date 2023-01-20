package com.petclinic.demo.controller;

import com.petclinic.demo.domain.User;
import com.petclinic.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-list")
    ResponseEntity<List<User>> userList() {
        List<User> userList = userService.getUserList();
        return ResponseEntity.ok(userList);
    }
    // end::get-aggregate-root[]

    @PostMapping("/")
    ResponseEntity saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("Saved successfully");
    }

    @PutMapping("/")
    ResponseEntity updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok("Updated successfully");
    }

    // Single item

    @GetMapping("/{id}")
    ResponseEntity<User> getUser(@PathVariable int id) {

        return ResponseEntity.ok(userService.getUser(id));
    }
}
