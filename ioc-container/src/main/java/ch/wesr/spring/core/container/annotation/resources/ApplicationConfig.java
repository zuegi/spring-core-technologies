package ch.wesr.spring.core.container.annotation.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean(name = "allerweltsBean")
    public SpringBean springBean() {
        return new SpringBean("René");
    }

    @Bean
    public SpringBean2 irgendeineBean() {
        return new SpringBean2("Paul");
    }

    @Bean
    public SpringBeanExplorer springBeanExplorer() {
        return new SpringBeanExplorer();
    }
}
