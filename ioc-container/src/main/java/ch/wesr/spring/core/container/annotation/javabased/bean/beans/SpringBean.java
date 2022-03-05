package ch.wesr.spring.core.container.annotation.javabased.bean.beans;

public class SpringBean {
    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
