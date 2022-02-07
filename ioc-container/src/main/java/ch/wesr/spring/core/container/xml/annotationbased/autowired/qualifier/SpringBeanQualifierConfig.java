package ch.wesr.spring.core.container.xml.annotationbased.autowired.qualifier;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class SpringBeanQualifierConfig {


    @Bean
    @Qualifier("primary")
    public SpringBean primaryBean() {
        SpringBean springBean = new SpringBean();
        springBean.setName("primary");
        return springBean;
    }

    @Bean
    @Qualifier("secondary")
    public SpringBean secondaryBean() {
        SpringBean springBean = new SpringBean();
        springBean.setName("secondary");
        return springBean;
    }
}
