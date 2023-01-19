package com.petclinic.demo.service;

import com.petclinic.demo.domain.Pet;
import com.petclinic.demo.domain.User;

import java.util.List;

public interface UserService {
    void addUser();

    void updateUser(User user);

    void saveUser(User user);

    User getUser(int id);

    List<User> getUserList();
}
