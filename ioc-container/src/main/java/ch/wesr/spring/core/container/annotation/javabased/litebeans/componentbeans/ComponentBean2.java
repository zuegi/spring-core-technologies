package ch.wesr.spring.core.container.annotation.javabased.litebeans.componentbeans;

public class ComponentBean2 {

    public void sayHello() {
        System.out.println("Hello from " +this.getClass().getSimpleName() +": " +this.hashCode());
    }

    private void init() {
        System.out.println(this.getClass().getSimpleName() +" created ... hashCode: " +this.hashCode() );
    }
}
