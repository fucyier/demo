package com.petclinic.demo.service.Impl;

import com.petclinic.demo.domain.User;
import com.petclinic.demo.repository.UserRepository;
import com.petclinic.demo.service.UserService;
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
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateUser(User user) {
        logger.info("UserServiceImpl/updateUser with user={}", user.toString());
    }

    @Override
    public void saveUser(User user) {
        logger.info("UserServiceImpl/saveUser with user={}", user.toString());
        userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public User getUser(int id) {
        logger.info("UserServiceImpl/getUser with id={}", id);
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) return null;
        return optionalUser.get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<User> getUserList() {
        logger.info("UserServiceImpl/getUserList");
        return userRepository.findAll();
    }
}
