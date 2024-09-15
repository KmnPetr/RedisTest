package com.example.redis_test.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableCaching
@EnableJpaRepositories(
        basePackages = "com.example.redis_test.repositories.jpa"
//        entityManagerFactoryRef = "jpaEntityManagerFactory",
//        transactionManagerRef = "jpaTransactionManager"
)
public class AppConfiguration {
}
