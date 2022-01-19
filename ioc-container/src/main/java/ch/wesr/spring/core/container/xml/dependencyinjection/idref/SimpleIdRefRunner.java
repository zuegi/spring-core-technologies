package ch.wesr.spring.core.container.xml.dependencyinjection.idref;

import ch.wesr.spring.core.container.xml.beans.IdRefBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleIdRefRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/idref/idref-configuration.xml");

        IdRefBean bean = context.getBean(IdRefBean.class);
        bean.sayHello();
    }
}
