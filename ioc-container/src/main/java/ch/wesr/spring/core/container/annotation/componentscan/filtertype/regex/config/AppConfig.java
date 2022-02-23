package ch.wesr.spring.core.container.annotation.componentscan.filtertype.regex.config;

import ch.wesr.spring.core.container.annotation.componentscan.filtertype.regex.beans.RegexMarkerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackageClasses = {RegexMarkerInterface.class},
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = ".*gB.*"))
public class AppConfig {
}
