package com.example.redis_test.services;

import com.example.redis_test.models.Book;
import com.example.redis_test.repositories.jpa.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository repository;

    @Cacheable(value = "book",unless = "#result == null")
    public Book findBookById(Long id){
        log.info("Calling findBookBiId...");
        Optional<Book> bookOptional = repository.findById(id);
        return bookOptional.orElse(null);
    }

    @Cacheable(value = "book", key = "#title", unless = "#result == null")
    public Book findBookByTitleAndAuthor(String title, String author) {
        log.info("Calling getBookById...");
        Optional<Book> bookOptional = repository.findBookByTitleAndAuthor(title, author);
        return bookOptional.orElse(null);
    }

    @CachePut(value = "book", key = "#book.id")
    public Book saveBook(Book book) {
        log.info("Calling saveBook...");
        return repository.save(book);
    }

    public Book saveBookWithoutCachePut(Book book) {
        log.info("Calling saveBookWithoutCachePut...");
        return repository.save(book);
    }

    @CacheEvict(value = "book", key = "#book.id")
    public void deleteBook(Book book) {
        log.info("Calling deleteBook...");
        repository.delete(book);
    }

    public void deleteBookWithoutCacheEvict(Book book) {
        log.info("Calling deleteBook...");
        repository.delete(book);
    }

}
