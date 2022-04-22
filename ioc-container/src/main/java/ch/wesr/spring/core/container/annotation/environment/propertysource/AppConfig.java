package ch.wesr.spring.core.container.annotation.environment.propertysource;


import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({
        @PropertySource("classpath:config.properties"),
        @PropertySource(value = "classpath:mich-gibt-es-nicht.properties", ignoreResourceNotFound = true)
})
@Configuration
public class AppConfig {


    @Value("${springbean.name}")
    private String springbeanName;

    @Value("${springbean.environment}")
    private String springbeanEnv;

    @Value("${springbean.module}")
    private String springBeanModule;


    @Bean
    public SpringBean springBean() {

        SpringBean springBean = new SpringBean();
        springBean.setName(springbeanName);
        springBean.setEnvironment(springbeanEnv);
        springBean.setModule(springBeanModule);

        return springBean;
    }
}
