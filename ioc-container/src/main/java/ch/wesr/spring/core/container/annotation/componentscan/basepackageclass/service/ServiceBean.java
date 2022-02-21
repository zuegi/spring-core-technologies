package ch.wesr.spring.core.container.annotation.componentscan.basepackageclass.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceBean {
    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
