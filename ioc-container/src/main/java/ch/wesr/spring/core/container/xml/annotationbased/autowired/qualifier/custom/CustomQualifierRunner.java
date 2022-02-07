package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomQualifierRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/custom-qualifier-autowired.xml");
        SpringBeanExplorer bean = context.getBean(SpringBeanExplorer.class);
        bean.explore();
    }
}
