package ch.wesr.spring.core.container.annotation.environment.multipleprofiles.config;

import ch.wesr.spring.core.container.annotation.environment.beans.SpringBean;
import ch.wesr.spring.core.container.annotation.environment.beans.SpringBeanB;
import ch.wesr.spring.core.container.annotation.environment.beans.SpringBeanC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"cprofile", "!aprofile"})
@Configuration
public class CConfiguration {

    @Bean
    public SpringBean springBean () {
        return new SpringBeanC();
    }

    @Bean
    public SpringBean springBeanB () {
        return new SpringBeanB();
    }

}
