package ch.wesr.spring.core.container.annotation.javabased.containerconfig.bean;

public class SpringBean {

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
