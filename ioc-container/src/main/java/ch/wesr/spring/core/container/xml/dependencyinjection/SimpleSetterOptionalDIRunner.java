package ch.wesr.spring.core.container.xml.dependencyinjection;

import ch.wesr.spring.core.container.xml.beans.SetterBasedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleSetterOptionalDIRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("setter-based-optional.xml");

        SetterBasedBean bean = context.getBean(SetterBasedBean.class);
        bean.sayHello();
    }
}
