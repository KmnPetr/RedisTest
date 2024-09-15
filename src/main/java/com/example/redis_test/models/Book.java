package com.example.redis_test.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name = "book")
@RedisHash("Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
}
