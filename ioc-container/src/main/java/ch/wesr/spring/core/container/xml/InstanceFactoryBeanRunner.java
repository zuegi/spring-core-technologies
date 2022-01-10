package ch.wesr.spring.core.container.xml;

import ch.wesr.spring.core.container.xml.beans.ClientService;
import ch.wesr.spring.core.container.xml.beans.SpringBeanService;
import ch.wesr.spring.core.container.xml.beans.SpringBeanService1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Objects;

public class InstanceFactoryBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");

        SpringBeanService1 springBeanService1 = context.getBean(SpringBeanService1.class);
        springBeanService1.sayHello();

        ClientService clientService = context.getBean(ClientService.class);
        clientService.sayHello();

        String clientServiceByLocator = context.getType("clientServiceByLocator").getName();
        assert clientServiceByLocator.equals("ch.wesr.spring.core.container.xml.beans.ClientService");
        System.out.println("Type of bean: " +clientServiceByLocator);

        Class<?> clientServiceByLocator1 = context.getType("clientServiceByLocator");
        assert Objects.requireNonNull(clientServiceByLocator1).isInstance(ClientService.class);

    }
}
