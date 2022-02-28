package ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.config;

import ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.bean.MandantBean;
import ch.wesr.spring.core.container.annotation.componentscan.customscoperesolver.bean.MandantMarkerInterface;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan(basePackageClasses = {MandantMarkerInterface.class, ConfigMarkerInterface.class},
        scopeResolver = CustomScopeMetadataResolver.class)
public class AppConfig {

    @Scope(scopeName = CustomScopeMetadataResolver.MANDANT)
    @Bean
    public MandantBean foo() {
        return new MandantBean("foo");
    }

    @Scope(scopeName = CustomScopeMetadataResolver.MANDANT)
    @Bean
    public MandantBean bar() {
        return new MandantBean("bar");
    }
}
