package ch.wesr.spring.core.container.xml.dependencyinjection.straightvalues;

import ch.wesr.spring.core.container.xml.beans.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimplePDataSource {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("straightvalues/p-basic-datasource.xml");

        BasicDataSource bean = context.getBean(BasicDataSource.class);
        bean.sayHello();
    }

}
