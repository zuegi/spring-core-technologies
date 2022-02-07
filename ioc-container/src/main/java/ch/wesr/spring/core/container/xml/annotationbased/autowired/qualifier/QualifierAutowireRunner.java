package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifierAutowireRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/qualifier-autowired.xml");
        SpringBeanExplorer springBeanExplorer =  context.getBean(SpringBeanExplorer.class);
        springBeanExplorer.explore();
    }
}
