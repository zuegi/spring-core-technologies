package ch.wesr.spring.core.container.xml.beans;

public class SpringBean1 {

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getName() +": " +this);
    }
}
