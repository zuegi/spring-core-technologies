package ch.wesr.spring.core.container.annotation.componentscan.filtertype.custom.config;


import ch.wesr.spring.core.container.annotation.componentscan.filtertype.custom.beans.CustomMarkerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackageClasses = {CustomMarkerInterface.class},
        includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM,
                classes = ComponentScanCustomFilter.class)
)
public class AppConfig {
}
