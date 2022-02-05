package ch.wesr.spring.core.container.xml.annotationbased.autowired;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredAnnotationBeanPostProcessorRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/annotation-based/autowired-annotation-bean-post-processor.xml");

        SpringBeanExplorer springBeanExplorer = (SpringBeanExplorer) context.getBean("springBeanExplorer");

        springBeanExplorer.explore();

    }
}
