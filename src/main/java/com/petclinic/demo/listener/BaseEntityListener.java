package com.petclinic.demo.listener;

import com.petclinic.demo.domain.BaseEntity;
import com.petclinic.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Component
public class BaseEntityListener {


    private static UserService userService;
    @Autowired
    public void init(UserService evenementPliRepository)
    {
        BaseEntityListener.userService = evenementPliRepository;

    }
    @Autowired
    public BaseEntityListener(UserService userService) {
        this.userService = userService;
    }

    public BaseEntityListener() {

    }

    @PrePersist
    void onPrePersist(BaseEntity entity) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("BaseEntityListener.onPrePersist(): " + entity.toString());

        int ids = userService.getUser(1).getId();
        entity.setCreated(ids);
        entity.setCreatedTime(LocalDateTime.now());
        entity.setUpdatedTime(LocalDateTime.now());

    }
}
