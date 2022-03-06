package ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.config;

import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.beans.GoodbySpringBean;
import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.beans.SpringBeanIfc;
import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.condition.IsSayGoodbyeCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(IsSayGoodbyeCondition.class)
public class GoodbyeConfig {

    @Bean
    public SpringBeanIfc goodbyeSpringBean() {
        return new GoodbySpringBean();
    }
}
