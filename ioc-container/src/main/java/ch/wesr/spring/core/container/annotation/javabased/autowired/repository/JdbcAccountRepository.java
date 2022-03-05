package ch.wesr.spring.core.container.annotation.javabased.autowired.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcAccountRepository extends AccountRepository {

    @Autowired
    MeineDataSource dataSource;

    public JdbcAccountRepository(MeineDataSource dataSource) {
        super();
    }
}
