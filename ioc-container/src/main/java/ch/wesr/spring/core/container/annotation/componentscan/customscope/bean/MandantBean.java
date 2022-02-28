package ch.wesr.spring.core.container.annotation.componentscan.customscope.bean;

public class MandantBean {
    private final String name;

    public MandantBean(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println(
                String.format("Hello from %s of type %s",
                        this.name,
                        this.getClass().getSimpleName()));
    }
}
