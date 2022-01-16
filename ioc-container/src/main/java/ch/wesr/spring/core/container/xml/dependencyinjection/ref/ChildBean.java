package ch.wesr.spring.core.container.xml.dependencyinjection.ref;

public class ChildBean {

    public void sayHello() {
        System.out.println("Ich bin die "+this.getClass().getSimpleName());
    }
}
