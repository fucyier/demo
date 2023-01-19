package com.petclinic.demo.service.Impl;

import com.petclinic.demo.domain.User;
import com.petclinic.demo.repository.UserRepository;
import com.petclinic.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser() {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }
}
