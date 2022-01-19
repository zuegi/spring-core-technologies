package ch.wesr.spring.core.container.xml.dependencyinjection.constructorbased;

import ch.wesr.spring.core.container.xml.beans.ConstructorBasedTypeMatchingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleConstructorNameRunner {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/constructorbased/constructor-based-name.xml");
        ConstructorBasedTypeMatchingBean bean = context.getBean(ConstructorBasedTypeMatchingBean.class);
        bean.sayHello();
    }
}
