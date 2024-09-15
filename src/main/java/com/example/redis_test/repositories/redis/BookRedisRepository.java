package com.example.redis_test.repositories.redis;

import com.example.redis_test.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRedisRepository extends CrudRepository<Book, Long> {
}
