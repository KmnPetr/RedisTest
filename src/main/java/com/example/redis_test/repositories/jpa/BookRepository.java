package com.example.redis_test.repositories.jpa;

import com.example.redis_test.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findBookByTitleAndAuthor(String title,String author);
}
