package ch.wesr.spring.core.container.annotation.javabased.containerconfig.bean;

import org.springframework.stereotype.Component;

@Component
public class ScannedSpringBean {

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
