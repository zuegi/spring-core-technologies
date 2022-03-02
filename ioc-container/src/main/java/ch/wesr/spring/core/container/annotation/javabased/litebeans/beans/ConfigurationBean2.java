package ch.wesr.spring.core.container.annotation.javabased.litebeans.beans;

public class ConfigurationBean2 {

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName() +": " +this);
    }

    private void init() {
        System.out.println("Created Bean: " +this.getClass().getSimpleName());
    }
}
