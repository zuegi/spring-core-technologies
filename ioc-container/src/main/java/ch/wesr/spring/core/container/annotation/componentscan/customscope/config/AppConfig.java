package ch.wesr.spring.core.container.annotation.componentscan.customscope.config;

import ch.wesr.spring.core.container.annotation.componentscan.customscope.bean.MandantBean;
import ch.wesr.spring.core.container.annotation.componentscan.customscope.scope.MandantBeanFactoryPostProcessor;
import ch.wesr.spring.core.container.annotation.componentscan.customscope.scope.MandantScope;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new MandantBeanFactoryPostProcessor();
    }

    @Scope(scopeName = MandantScope.MANDANT)
    @Bean
    public MandantBean foo() {
        return new MandantBean("foo");
    }

    @Scope(scopeName =  MandantScope.MANDANT)
    @Bean
    public MandantBean bar() {
        return new MandantBean("bar");
    }
}
