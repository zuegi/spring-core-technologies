package ch.wesr.spring.core.container.xml.dependencyinjection.setterbased;

import ch.wesr.spring.core.container.xml.beans.SetterBasedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleSetterDIRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("setterbased/setter-based.xml");

        SetterBasedBean bean = context.getBean(SetterBasedBean.class);
        bean.sayHello();
    }
}
