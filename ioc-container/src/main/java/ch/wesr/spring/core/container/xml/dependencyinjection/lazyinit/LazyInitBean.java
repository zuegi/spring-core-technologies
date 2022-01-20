package ch.wesr.spring.core.container.xml.dependencyinjection.lazyinit;

public class LazyInitBean {

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName());
    }
}
