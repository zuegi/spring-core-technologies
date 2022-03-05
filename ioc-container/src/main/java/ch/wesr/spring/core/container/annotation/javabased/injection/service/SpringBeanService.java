package ch.wesr.spring.core.container.annotation.javabased.injection.service;

import ch.wesr.spring.core.container.annotation.javabased.injection.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class SpringBeanService {

    private AccountRepository accountRepository;

    public SpringBeanService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
