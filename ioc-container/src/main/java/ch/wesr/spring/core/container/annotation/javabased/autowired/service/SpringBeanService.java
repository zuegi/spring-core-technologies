package ch.wesr.spring.core.container.annotation.javabased.autowired.service;

import ch.wesr.spring.core.container.annotation.javabased.injection.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringBeanService {

    @Autowired
    AccountRepository accountRepository;

}
