package ch.wesr.spring.core.container.xml.dependencyinjection.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleRefRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/ref/simple-ref.xml");

        RefBean bean = context.getBean(RefBean.class);
        bean.sayHello();
    }
}
