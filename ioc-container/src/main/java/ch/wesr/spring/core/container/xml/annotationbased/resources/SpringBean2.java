package ch.wesr.spring.core.container.xml.annotationbased.resources;

public class SpringBean2 {

    private String name;


    public void sayHello() {
        System.out.println("Hello " +name +" from " +this.getClass().getSimpleName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}