package ch.wesr.spring.core.container.xml.dependencyinjection.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleRefBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/autowire/ref.xml");
        AutowireBean bean = context.getBean(AutowireBean.class);
        bean.sayHello();
    }
}
