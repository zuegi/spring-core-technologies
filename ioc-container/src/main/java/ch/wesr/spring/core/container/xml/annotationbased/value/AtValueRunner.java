package ch.wesr.spring.core.container.xml.annotationbased.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtValueRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/annotation-based/value.xml");
        SpringBean bean = (SpringBean) context.getBean("springBean");
        bean.sayHello();
    }
}
