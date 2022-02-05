package ch.wesr.spring.core.container.xml.annotationbased.autowired.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class PrimaryAutowireBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/primary-autowired.xml");
        SpringBean springBean = context.getBean(SpringBean.class);
        springBean.sayHello();
    }
}
