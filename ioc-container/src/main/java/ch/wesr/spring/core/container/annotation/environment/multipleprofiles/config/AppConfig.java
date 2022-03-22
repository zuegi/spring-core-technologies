package ch.wesr.spring.core.container.annotation.environment.multipleprofiles.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "ch.wesr.spring.core.container.annotation.environment.multipleprofiles")
@Configuration
public class AppConfig {
}
