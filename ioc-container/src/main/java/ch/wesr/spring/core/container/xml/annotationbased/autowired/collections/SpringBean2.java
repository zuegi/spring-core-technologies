package ch.wesr.spring.core.container.xml.annotationbased.autowired.collections;

public class SpringBean2 implements MeineBean {

    @Override
    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getSimpleName());
    }
}
