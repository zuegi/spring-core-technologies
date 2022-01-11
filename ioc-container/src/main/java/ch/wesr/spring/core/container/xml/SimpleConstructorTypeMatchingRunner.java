package ch.wesr.spring.core.container.xml;

import ch.wesr.spring.core.container.xml.beans.ConstructorBasedTypeMatchingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleConstructorTypeMatchingRunner {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("constructor-based-index-matching.xml");
        ConstructorBasedTypeMatchingBean bean = context.getBean(ConstructorBasedTypeMatchingBean.class);
        bean.sayHello();
    }
}
