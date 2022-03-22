package ch.wesr.spring.core.container.annotation.environment.multipleprofiles.config;

import ch.wesr.spring.core.container.annotation.environment.beans.SpringBean;
import ch.wesr.spring.core.container.annotation.environment.beans.SpringBeanA;
import ch.wesr.spring.core.container.annotation.environment.beans.SpringBeanB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"aprofile", "!cprofile"})
@Configuration
public class AConfiguration {

    @Bean
    public SpringBean springBean () {
        return new SpringBeanA();
    }

    @Bean
    public SpringBean springBeanB () {
        return new SpringBeanB();
    }
}
