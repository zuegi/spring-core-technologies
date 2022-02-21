package ch.wesr.spring.core.container.annotation.componentscan.basepackageclass.client;

import org.springframework.stereotype.Component;

@Component
public class ClientBean {
    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
