package ch.wesr.spring.core.container.annotation.javabased.injection.config;

import ch.wesr.spring.core.container.annotation.javabased.injection.repository.AccountRepository;
import ch.wesr.spring.core.container.annotation.javabased.injection.repository.JdbcAccountRepository;
import ch.wesr.spring.core.container.annotation.javabased.injection.repository.MeineDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    @Bean
    public AccountRepository accountRepository(MeineDataSource dataSource) {
        return new JdbcAccountRepository(dataSource);
    }
}
