package ch.wesr.spring.core.container.annotation.componentscan.custombeannaming.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

public class CustomBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {
        String beanClassName = beanDefinition.getBeanClassName();
        String simpleClassname = beanClassName.substring(beanClassName.lastIndexOf('.') + 1);

        return "meineAllerwelts"+simpleClassname;
    }
}
