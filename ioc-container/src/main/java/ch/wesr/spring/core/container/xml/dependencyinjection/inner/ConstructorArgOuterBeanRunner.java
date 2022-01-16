package ch.wesr.spring.core.container.xml.dependencyinjection.inner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorArgOuterBeanRunner {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("inner/constructor-arg-inner-bean.xml");
        ConstructorArgOuterBean bean = context.getBean(ConstructorArgOuterBean.class);

        bean.sayHello();
    }
}
