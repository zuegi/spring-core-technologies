package ch.wesr.spring.core.container.xml.profiles.profile.beans;

public class AbstractSpringBean {

    public void sayHello() {
        System.out.println("Hello from " +this.getClass());
    }
}
