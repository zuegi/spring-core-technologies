package ch.wesr.spring.core.container.xml.beans;

public class SpringBeanService {

    private static SpringBeanService springBeanService;

    public static SpringBeanService erstelleSpringBeanService() {
        springBeanService = new SpringBeanService();
        return springBeanService;
    }

    public void sayHello() {
        System.out.println("Hello from " + this.getClass().getName() /*+ ": " + this*/);
    }
}
