package ch.wesr.spring.core.container.xml.dependencyinjection.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KomplexeBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/collections/collections.xml");
        KomplexeBean bean = context.getBean(KomplexeBean.class);
        bean.sayHello();
    }
}
