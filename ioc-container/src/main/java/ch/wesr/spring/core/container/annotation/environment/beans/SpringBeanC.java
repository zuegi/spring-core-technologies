package ch.wesr.spring.core.container.annotation.environment.beans;

public class SpringBeanC implements SpringBean {
    @Override
    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
