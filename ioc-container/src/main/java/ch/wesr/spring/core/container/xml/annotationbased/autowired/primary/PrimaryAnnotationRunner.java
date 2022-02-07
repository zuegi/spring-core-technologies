package ch.wesr.spring.core.container.xml.annotationbased.autowired.primary;

import ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier.SpringBeanQualifierConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class PrimaryAnnotationRunner {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/annotation-primary-autowired.xml");
        SpringBeanExplorer springBeanExplorer = (SpringBeanExplorer) context.getBean("springBeanExplorer");
        springBeanExplorer.explore();
    }
}
