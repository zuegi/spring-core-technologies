package ch.wesr.spring.core.container.annotation.resources;

public class SpringBean2 {

    private String name;

    public SpringBean2(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " +name +" from " +this.getClass().getSimpleName());
    }
}
