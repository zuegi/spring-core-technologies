package ch.wesr.spring.core.container.annotation.environment.profile.config;

import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBean;
import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBeanA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("aprofile")
@Configuration
public class AConfiguration {

    @Bean
    public SpringBean springBean () {
        return new SpringBeanA();
    }

}
