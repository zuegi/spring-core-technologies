package ch.wesr.spring.core.container.annotation.javabased.autowired.config;

import ch.wesr.spring.core.container.annotation.javabased.injection.repository.AccountRepository;
import ch.wesr.spring.core.container.annotation.javabased.injection.repository.JdbcAccountRepository;
import ch.wesr.spring.core.container.annotation.javabased.injection.repository.MeineDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Autowired
    MeineDataSource dataSource;

    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepository(dataSource);
    }
}
