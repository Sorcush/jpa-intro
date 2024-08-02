package com.example.jpaintro.jpaintro.repository;

import com.example.jpaintro.jpaintro.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
