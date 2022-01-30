package ch.wesr.spring.core.container.xml.containerextensionpoints;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass().getSimpleName() +".postProcessBeforeInitialization() aufgerufen für: " +bean.getClass().getSimpleName() +", beanName: "+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass().getSimpleName() +".postProcessAfterInitialization() aufgerufen für: "+bean.getClass().getSimpleName() +", beanName" +beanName);
        return bean;
    }
}
