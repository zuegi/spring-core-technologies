package ch.wesr.spring.core.container.annotation.javabased.bean.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "ch.wesr.spring.core.container.annotation.javabased.bean.beans")
@Configuration
public class AppConfig implements BaseConfig {
}
