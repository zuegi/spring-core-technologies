package ch.wesr.spring.core.container.xml.containerextensionpoints.beanfactorypostprocessor;

import ch.wesr.spring.core.container.xml.containerextensionpoints.SpringBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomBeanFactoryPostProcessorRunner  {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dependencies/containerextensionpoints/bean-factory-post-processor.xml");
        context.registerShutdownHook();

        SpringBean bean = (SpringBean) context.getBean("springBean");
        bean.sayHello();
    }
}
