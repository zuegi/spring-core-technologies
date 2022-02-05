package ch.wesr.spring.core.container.xml.annotationbased.autowired.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrimaryAnnotationRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/annotation-primary-autowired.xml");
        SpringBean springBean = context.getBean(SpringBean.class);
        springBean.sayHello();
    }
}
