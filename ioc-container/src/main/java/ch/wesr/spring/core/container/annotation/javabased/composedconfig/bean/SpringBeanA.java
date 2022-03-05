package ch.wesr.spring.core.container.annotation.javabased.composedconfig.bean;

public class SpringBeanA {
    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
