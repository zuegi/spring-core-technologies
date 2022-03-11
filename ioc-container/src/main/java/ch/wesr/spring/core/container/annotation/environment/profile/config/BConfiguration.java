package ch.wesr.spring.core.container.annotation.environment.profile.config;

import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBean;
import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("bprofile")
@Configuration
public class BConfiguration {

    @Bean
    public SpringBean springBean () {
        return new SpringBeanB();
    }

}
