package ch.wesr.spring.core.container.annotation.componentscan.basepackageclass.config;

import ch.wesr.spring.core.container.annotation.componentscan.basepackageclass.client.ClientMarkerInterface;
import ch.wesr.spring.core.container.annotation.componentscan.basepackageclass.service.ServiceMarkerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {ClientMarkerInterface.class, ServiceMarkerInterface.class})
public class AppConfig {
}
