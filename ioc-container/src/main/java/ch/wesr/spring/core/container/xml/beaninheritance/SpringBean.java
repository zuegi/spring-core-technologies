package ch.wesr.spring.core.container.xml.beaninheritance;

public class SpringBean {

    private String baseName;
    private String name;

    public void sayHello() {
        System.out.println("Hello from " +getName() +" mit baseName: " +getBaseName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
