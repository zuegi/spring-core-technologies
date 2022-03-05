package ch.wesr.spring.core.container.annotation.javabased.injection.config;




import ch.wesr.spring.core.container.annotation.javabased.injection.repository.AccountRepository;
import ch.wesr.spring.core.container.annotation.javabased.injection.service.SpringBeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public SpringBeanService springBeanService(AccountRepository accountRepository) {
        return new SpringBeanService(accountRepository);
    }
}
