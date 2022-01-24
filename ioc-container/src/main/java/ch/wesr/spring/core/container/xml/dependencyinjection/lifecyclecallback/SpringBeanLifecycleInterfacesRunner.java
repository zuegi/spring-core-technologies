package ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLifecycleInterfacesRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/spring-bean-lifecycle-callbacks.xml");
        SpringBeanLifecycleInterfaces bean = context.getBean(SpringBeanLifecycleInterfaces.class);
        bean.sayHello();

        context.close();
    }
}
