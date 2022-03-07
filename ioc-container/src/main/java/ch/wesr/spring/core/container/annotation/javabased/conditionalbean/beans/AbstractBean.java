package ch.wesr.spring.core.container.annotation.javabased.conditionalbean.beans;

public class AbstractBean {

    public void sayAnything() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
