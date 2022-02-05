package ch.wesr.spring.core.container.xml.annotationbased.autowired.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringBeanConfig {

    @Primary
    @Bean
    public SpringBean primaryBean() {
        SpringBean springBean = new SpringBean();
        springBean.setName("primary");
        return springBean;
    }

    @Bean
    public SpringBean secondaryBean() {
        SpringBean springBean = new SpringBean();
        springBean.setName("secondary");
        return springBean;
    }
}
