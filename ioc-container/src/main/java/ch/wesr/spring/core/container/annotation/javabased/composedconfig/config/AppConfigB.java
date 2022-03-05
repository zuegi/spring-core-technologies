package ch.wesr.spring.core.container.annotation.javabased.composedconfig.config;

import ch.wesr.spring.core.container.annotation.javabased.composedconfig.bean.SpringBeanA;
import ch.wesr.spring.core.container.annotation.javabased.composedconfig.bean.SpringBeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigB {

    @Bean
    public SpringBeanB springBeanB() {
        return new SpringBeanB();
    }
}
