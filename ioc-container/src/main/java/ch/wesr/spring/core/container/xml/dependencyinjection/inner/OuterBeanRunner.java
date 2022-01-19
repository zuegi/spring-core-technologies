package ch.wesr.spring.core.container.xml.dependencyinjection.inner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OuterBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/inner/property-inner-bean.xml");

        OuterBean bean = context.getBean(OuterBean.class);
        bean.sayHello();
    }
}
