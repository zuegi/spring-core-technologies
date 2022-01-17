package ch.wesr.spring.core.container.xml.dependencyinjection.schemanamespaces;

import ch.wesr.spring.core.container.xml.beans.BasicDataSource;
import ch.wesr.spring.core.container.xml.beans.ConstructorBasedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleCDataSource {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("schema-namespaces/c-basic-datasource.xml");

        ConstructorBasedBean bean = context.getBean(ConstructorBasedBean.class);
        bean.sayHello();

        AnotherConstructorBasedBean anotherConstructorBasedBean = context.getBean(AnotherConstructorBasedBean.class);
        anotherConstructorBasedBean.sayHello();

    }

}
