package ch.wesr.spring.core.container.annotation.javabased.autowired.config;




import ch.wesr.spring.core.container.annotation.javabased.injection.repository.AccountRepository;
import ch.wesr.spring.core.container.annotation.javabased.injection.service.SpringBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    AccountRepository accountRepository;

    @Bean
    public SpringBeanService springBeanService() {
        return new SpringBeanService(accountRepository);
    }
}
