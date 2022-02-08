package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.generics;

public class SpringBean1 implements GenericsQualifier<String> {

    private String name;

    @Override
    public void sayHello() {
        System.out.println("Hello " +name +" from" +this.getClass().getSimpleName());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
