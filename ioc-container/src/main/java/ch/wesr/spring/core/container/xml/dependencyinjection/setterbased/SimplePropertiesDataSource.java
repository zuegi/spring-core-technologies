package ch.wesr.spring.core.container.xml.dependencyinjection.setterbased;

import ch.wesr.spring.core.container.xml.beans.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimplePropertiesDataSource {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("property-source-placeholder.xml");

        BasicDataSource bean = context.getBean(BasicDataSource.class);
        bean.sayHello();
    }

}
