package ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.config;


import ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.BenutzerDefinierterScan;
import ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.explore.ExplorerMarkerInterface;
import ch.wesr.spring.core.container.annotation.componentscan.filtertype.annotation.service.ServiceMarkerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackageClasses = {ExplorerMarkerInterface.class, ServiceMarkerInterface.class},
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {BenutzerDefinierterScan.class})
)
public class AppConfig {
}
