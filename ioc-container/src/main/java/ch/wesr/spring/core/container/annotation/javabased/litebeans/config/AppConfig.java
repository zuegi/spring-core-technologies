package ch.wesr.spring.core.container.annotation.javabased.litebeans.config;

import ch.wesr.spring.core.container.annotation.javabased.litebeans.beans.BeanMarkerInterface;
import ch.wesr.spring.core.container.annotation.javabased.litebeans.beans.ConfigurationBean1;
import ch.wesr.spring.core.container.annotation.javabased.litebeans.beans.ConfigurationBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {BeanMarkerInterface.class})
public class AppConfig {

    @Bean
    public ConfigurationBean1 configurationBean1() {
        return new ConfigurationBean1(configurationBean2());
    }

    @Bean
    public ConfigurationBean2 configurationBean2() {
        return new ConfigurationBean2();
    }
}
