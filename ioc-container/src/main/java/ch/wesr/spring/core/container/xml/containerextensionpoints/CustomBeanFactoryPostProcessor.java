package ch.wesr.spring.core.container.xml.containerextensionpoints;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String newMessage = "Das ist eine in der Bean Definition veränderte \"Hello from\" Message";

        System.out.println("Die Bean Defintion wird gelesen bevor Instanzen erstellt werden.");
        System.out.println("\t" +this.getClass().getSimpleName() +".postProcessBeanFactory() aufgerufen und das Property message wird gesetzt mit: " +newMessage);

        // tu das nicht, es verletzt den Container Lifecycle
//        SpringBean springBean = (SpringBean) configurableListableBeanFactory.getBean("springBean");
//        springBean.setMessage("Das ist eine verändertet Hello from Message:");

        PropertyValue pv = new PropertyValue("message", newMessage);

        BeanDefinition springBeanDefinition = configurableListableBeanFactory.getBeanDefinition("springBean");
        springBeanDefinition .getPropertyValues().addPropertyValue(pv);

    }
}
