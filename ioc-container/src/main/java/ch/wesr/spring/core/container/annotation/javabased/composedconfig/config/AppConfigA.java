package ch.wesr.spring.core.container.annotation.javabased.composedconfig.config;

import ch.wesr.spring.core.container.annotation.javabased.composedconfig.bean.SpringBeanA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfigB.class})
public class AppConfigA {

    @Bean
    public SpringBeanA springBeanA() {
        return new SpringBeanA();
    }
}
