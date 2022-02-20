package ch.wesr.spring.core.container.annotation.customscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "ch.wesr.spring.core.container.annotation.customscan",
    includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SayHelloBean.class})
)
public class AppConfig {

    @Bean
    SpringBean springBean() {
        return new SpringBean();
    }

}
