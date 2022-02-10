package ch.wesr.spring.core.container.annotation.resources;

public class SpringBean {

    private String name;

    public SpringBean(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " +name +" from " +this.getClass().getSimpleName());
    }
}
