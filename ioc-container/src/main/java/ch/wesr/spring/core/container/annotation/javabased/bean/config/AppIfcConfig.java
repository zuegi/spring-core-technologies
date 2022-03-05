package ch.wesr.spring.core.container.annotation.javabased.bean.config;


import ch.wesr.spring.core.container.annotation.javabased.bean.beans.SpringBeanIfc;
import ch.wesr.spring.core.container.annotation.javabased.bean.beans.SpringBeanImpl;
import org.springframework.context.annotation.Bean;

public class AppIfcConfig {

    @Bean
    public SpringBeanIfc springBean() {
        return new SpringBeanImpl();
    }
}
