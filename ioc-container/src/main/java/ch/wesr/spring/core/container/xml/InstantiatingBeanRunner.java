package ch.wesr.spring.core.container.xml;

import ch.wesr.spring.core.container.xml.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Die Packages org.springframework.context und org.springframework.beans
 * gehören zur Basis des IoC (Inversion of Control / Dependency Injection) Container des Springframework
 *
 *  @author wesr
 *  @version 0.1
 *  @since   2022-01-07
 */
public class InstantiatingBeanRunner {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");

        SpringBeanService springBeanService = context.getBean(SpringBeanService.class);
        springBeanService.sayHello();

    }
}
