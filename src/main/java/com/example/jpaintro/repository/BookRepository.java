package com.example.jpaintro.repository;

import com.example.jpaintro.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
