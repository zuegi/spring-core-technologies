package ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.beans;

public class HelloSpringBean implements SpringBeanIfc {
    @Override
    public void sayAnything() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
