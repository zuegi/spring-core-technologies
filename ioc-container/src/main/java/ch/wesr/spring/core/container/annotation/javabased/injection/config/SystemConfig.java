package ch.wesr.spring.core.container.annotation.javabased.injection.config;

import ch.wesr.spring.core.container.annotation.javabased.injection.repository.MeineDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ServiceConfig.class, RepositoryConfig.class})
@Configuration
public class SystemConfig {

    @Bean
    public MeineDataSource dataSource() {
        return new MeineDataSource();
    }
}
