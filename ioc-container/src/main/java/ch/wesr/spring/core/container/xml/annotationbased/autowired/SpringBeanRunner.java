package ch.wesr.spring.core.container.xml.annotationbased.autowired;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/annotation-based/annotation-based.xml");
        SpringBeanExplorer springBeanExplorer = (SpringBeanExplorer) context.getBean("springBeanExplorer");

        springBeanExplorer.explore();
    }
}
