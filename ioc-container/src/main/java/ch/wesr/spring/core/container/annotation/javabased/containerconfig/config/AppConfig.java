package ch.wesr.spring.core.container.annotation.javabased.containerconfig.config;



import ch.wesr.spring.core.container.annotation.javabased.containerconfig.bean.SpringBean;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public SpringBean springBean() {
        return new SpringBean();
    }
}
