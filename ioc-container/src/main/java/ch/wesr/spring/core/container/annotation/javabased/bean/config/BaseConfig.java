package ch.wesr.spring.core.container.annotation.javabased.bean.config;

import ch.wesr.spring.core.container.annotation.javabased.bean.beans.SpringBeanImpl;
import ch.wesr.spring.core.container.annotation.javabased.containerconfig.bean.SpringBean;
import org.springframework.context.annotation.Bean;

public interface BaseConfig {

    @Bean
    default SpringBean springBean() {
        return new SpringBean();
    }

}
