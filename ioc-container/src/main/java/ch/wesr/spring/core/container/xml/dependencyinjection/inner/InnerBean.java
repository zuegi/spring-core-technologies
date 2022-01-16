package ch.wesr.spring.core.container.xml.dependencyinjection.inner;

public class InnerBean {
    private String name;
    private int alter;

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
        System.out.println("\tMeine Atrributte sind ->  name: " + name + ", alter: " + alter);

    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
