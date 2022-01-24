package ch.wesr.spring.core.container.xml.dependencyinjection.lifecyclecallback;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestroySpringBeanRunner {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/lifecyclecallback/per-bean-init-destroy-method.xml");
        InitDestroySpringBean bean = context.getBean(InitDestroySpringBean.class);
        bean.sayHello();

        context.close();
    }

}
