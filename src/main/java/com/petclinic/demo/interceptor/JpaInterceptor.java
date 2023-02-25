package com.petclinic.demo.interceptor;

import com.petclinic.demo.domain.BaseEntity;
import com.petclinic.demo.service.UserService;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.LocalDateTime;

@Component
public class JpaInterceptor extends EmptyInterceptor {

    @Autowired
    @Lazy
    private UserService userService;

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof BaseEntity) {
            int ids = userService.getUser(1).getId();
            ((BaseEntity) entity).setCreated(ids);
            ((BaseEntity) entity).setCreatedTime(LocalDateTime.now());
            return super.onSave(entity, id, state, propertyNames, types);
        }
        return false;
    }
}
