package com.petclinic.demo.service;

import com.petclinic.demo.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void updateUser(User user);

    void saveUser(User user);

    User getUser(int id);

    List<User> getUserList();
}
