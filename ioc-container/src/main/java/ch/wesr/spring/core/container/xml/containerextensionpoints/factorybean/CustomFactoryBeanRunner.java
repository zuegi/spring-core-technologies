package ch.wesr.spring.core.container.xml.containerextensionpoints.factorybean;

import ch.wesr.spring.core.container.xml.containerextensionpoints.SpringBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomFactoryBeanRunner {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("dependencies/containerextensionpoints/factory-bean.xml");
        // erhalte das Produkt der custombeanFactory
        SpringBean springBean1 = (SpringBean) context.getBean("customFactoryBean");
        springBean1.sayHello();

        // Erhalte die Instanz der customBeanFactory
        CustomFactoryBean customFactoryBean = (CustomFactoryBean) context.getBean("&customFactoryBean");
        SpringBean springBean = customFactoryBean.getObject();
        springBean.sayHello();
    }
}
