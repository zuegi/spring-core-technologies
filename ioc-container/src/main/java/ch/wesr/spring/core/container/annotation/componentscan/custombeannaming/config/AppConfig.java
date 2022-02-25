package ch.wesr.spring.core.container.annotation.componentscan.custombeannaming.config;

import ch.wesr.spring.core.container.annotation.componentscan.custombeannaming.bean.BeanMarkerInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {BeanMarkerInterface.class}, nameGenerator = CustomBeanNameGenerator.class)
public class AppConfig {
}
