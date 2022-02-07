package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.custom;

public class SpringBean {

    private String name;

    public void sayHello() {
        System.out.println("Hello " +name  +" from " +this.getClass().getSimpleName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
