package com.petclinic.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JpaInterceptorRegistration implements HibernatePropertiesCustomizer {

    @Autowired
    private JpaInterceptor myInterceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
    //    hibernateProperties.put("hibernate.session_factory.interceptor", myInterceptor);
    }
}