package ch.wesr.spring.core.container.xml.containerextensionpoints;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomFactoryBeanRunner {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/containerextensionpoints/factory-bean.xml");

        CustomFactoryBean customFactoryBean = (CustomFactoryBean) context.getBean("&customFactoryBean");
        SpringBean springBean = customFactoryBean.getObject();
        springBean.sayHello();

        SpringBean springBean1 = (SpringBean) context.getBean("customFactoryBean");
        springBean1.sayHello();
    }
}
