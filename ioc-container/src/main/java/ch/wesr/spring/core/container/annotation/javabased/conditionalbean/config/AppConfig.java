package ch.wesr.spring.core.container.annotation.javabased.conditionalbean.config;

import ch.wesr.spring.core.container.annotation.javabased.conditionalbean.beans.AbstractBean;
import ch.wesr.spring.core.container.annotation.javabased.conditionalbean.beans.GoodByeBean;
import ch.wesr.spring.core.container.annotation.javabased.conditionalbean.beans.HelloBean;
import ch.wesr.spring.core.container.annotation.javabased.conditionalbean.condition.IsToSayGoodbyeCondition;
import ch.wesr.spring.core.container.annotation.javabased.conditionalbean.condition.IsToSayHelloCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    @Conditional(IsToSayHelloCondition.class)
    public AbstractBean helloBean() {
        return new HelloBean();
    }

    @Bean
    @Conditional(IsToSayGoodbyeCondition.class)
    public AbstractBean goodbyeBean() {
        return new GoodByeBean();
    }
}
