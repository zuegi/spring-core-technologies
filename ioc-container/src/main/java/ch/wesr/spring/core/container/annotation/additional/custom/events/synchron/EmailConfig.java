package ch.wesr.spring.core.container.annotation.additional.custom.events.synchron;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:props/email-config.properties")
@ComponentScan(basePackages = "ch.wesr.spring.core.container.annotation.additional.custom.events.synchron")
@Configuration
public class EmailConfig {
}
