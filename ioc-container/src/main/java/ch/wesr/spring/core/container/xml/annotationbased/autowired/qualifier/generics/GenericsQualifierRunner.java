package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.generics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GenericsQualifierRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/generic-qualifier.xml");
        SpringBeanExplorer bean = context.getBean(SpringBeanExplorer.class);
        bean.explore();
    }
}
