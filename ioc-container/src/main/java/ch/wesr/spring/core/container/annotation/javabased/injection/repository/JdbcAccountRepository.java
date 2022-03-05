package ch.wesr.spring.core.container.annotation.javabased.injection.repository;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcAccountRepository extends AccountRepository {

    public JdbcAccountRepository(MeineDataSource dataSource) {
        super();
    }
}
