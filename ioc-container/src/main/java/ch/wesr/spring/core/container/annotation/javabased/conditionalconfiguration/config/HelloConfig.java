package ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.config;

import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.beans.HelloSpringBean;
import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.beans.SpringBeanIfc;
import ch.wesr.spring.core.container.annotation.javabased.conditionalconfiguration.condition.IsSayHelloCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(IsSayHelloCondition.class)
public class HelloConfig {

    @Bean
    public SpringBeanIfc helloSpringBean() {
        return new HelloSpringBean();
    }

}
