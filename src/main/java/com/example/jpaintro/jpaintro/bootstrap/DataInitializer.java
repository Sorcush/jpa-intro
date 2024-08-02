package com.example.jpaintro.jpaintro.bootstrap;

import com.example.jpaintro.jpaintro.entity.Book;
import com.example.jpaintro.jpaintro.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args)  {
        Book bookDDD = new Book("Domain Driven Design", "123", "Random House");
        Book savedDDD = bookRepository.save(bookDDD);
        log.info("Saved book: {}", savedDDD);


        Book bookSIA= new Book("Spring In Action", "123354234", "Oriel");
        Book savedSIA = bookRepository.save(bookSIA);
        log.info("Saved book: {}", savedSIA);

        for (Book book : bookRepository.findAll()) {
            log.info("Book found: {}", book);
        }
    }
}
