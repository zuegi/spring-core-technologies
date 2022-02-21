package ch.wesr.spring.core.container.annotation.componentscan.filtertype.assignabletype;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "ch.wesr.spring.core.container.annotation.componentscan.filtertype.assignabletype",
    includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SayHelloBean.class})
)
public class AppConfig {


}
