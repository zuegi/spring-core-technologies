package ch.wesr.spring.core.container.xml.dependencyinjection;

import ch.wesr.spring.core.container.xml.beans.ConstructorBasedTypeMatchingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleConstructorTypeIndexRunner {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("constructor-based-type-matching.xml");
        ConstructorBasedTypeMatchingBean bean = context.getBean(ConstructorBasedTypeMatchingBean.class);
        bean.sayHello();
    }
}
