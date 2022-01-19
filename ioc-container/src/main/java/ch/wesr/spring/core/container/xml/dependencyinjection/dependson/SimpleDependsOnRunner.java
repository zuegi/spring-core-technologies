package ch.wesr.spring.core.container.xml.dependencyinjection.dependson;

import ch.wesr.spring.core.container.xml.beans.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleDependsOnRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/dependson/depends-on.xml");
        DependsOnBean bean = context.getBean(DependsOnBean.class);
        bean.sayHello();
    }
}
