package ch.wesr.spring.core.container.xml.dependencyinjection.constructorbased;

import ch.wesr.spring.core.container.xml.beans.ConstructorBasedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleConstructorBasedRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructorbased/constructor-based.xml");

        ConstructorBasedBean constructorBasedBean = context.getBean(ConstructorBasedBean.class);
        constructorBasedBean.sayHello();
    }
}
