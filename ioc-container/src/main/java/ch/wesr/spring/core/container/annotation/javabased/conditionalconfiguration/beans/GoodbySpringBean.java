package ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.beans;

public class GoodbySpringBean implements SpringBeanIfc {
    @Override
    public void sayAnything() {
        System.out.println("Goodbye from " +this.getClass().getSimpleName());
    }
}
