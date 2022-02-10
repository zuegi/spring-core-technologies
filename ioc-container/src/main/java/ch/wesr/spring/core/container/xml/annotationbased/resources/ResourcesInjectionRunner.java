package ch.wesr.spring.core.container.xml.annotationbased.resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourcesInjectionRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/annotation-based/resources-annotation.xml");
        SpringBeanExplorer springBeanExplorer = (SpringBeanExplorer) context.getBean("springBeanExplorer");
        springBeanExplorer.explore();
    }
}
