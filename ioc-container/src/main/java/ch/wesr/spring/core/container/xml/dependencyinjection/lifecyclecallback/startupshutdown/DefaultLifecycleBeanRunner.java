package ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback.startupshutdown;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DefaultLifecycleBeanRunner {


    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/lifecycle-processor.xml");
        context.registerShutdownHook();
        SpringBeanLifecycle bean = context.getBean(SpringBeanLifecycle.class);
        Thread.sleep(3000L);
        bean.sayHello();
    }

}
