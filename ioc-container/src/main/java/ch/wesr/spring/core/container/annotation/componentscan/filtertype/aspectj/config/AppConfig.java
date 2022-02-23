package ch.wesr.spring.core.container.annotation.componentscan.filtertype.aspectj.config;

import ch.wesr.spring.core.container.annotation.componentscan.filtertype.aspectj.beans.AspectJMarkerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackageClasses = {AspectJMarkerInterface.class},
        includeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
        pattern = "ch.wesr.spring.core.container.annotation.componentscan.filtertype.aspectj.beans.* "
                + "&& !(ch.wesr.spring.core.container.annotation.componentscan.filtertype.aspectj.beans.Spring2* "
                + "|| ch.wesr.spring.core.container.annotation.componentscan.filtertype.aspectj.beans.*Bean2)"))
public class AppConfig {
}
