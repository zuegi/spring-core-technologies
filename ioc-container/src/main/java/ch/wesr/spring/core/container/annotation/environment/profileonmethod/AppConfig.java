package ch.wesr.spring.core.container.annotation.environment.profileonmethod;

import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBean;
import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBeanA;
import ch.wesr.spring.core.container.annotation.environment.profile.beans.SpringBeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = {"ch.wesr.spring.core.container.annotation.environment.profileonmethod", "ch.wesr.spring.core.container.annotation.environment.beans"})
public class AppConfig {

    @Bean
    @Profile("aprofile")
    public SpringBean springBean() {
        return new SpringBeanA();
    }

    @Bean
    @Profile("bprofile")
    public SpringBean springBeanB() {
        return new SpringBeanB();
    }
}
