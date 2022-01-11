package ch.wesr.spring.core.container.xml.beans;

public class ConstructorBasedTypeMatchingBean {
    private final int zahl;
    private final String hello;

    public ConstructorBasedTypeMatchingBean(int zahl, String hello) {
        this.zahl = zahl;
        this.hello = hello;
    }

    public void sayHello() {
        System.out.println(hello +" " +zahl);
    }
}
