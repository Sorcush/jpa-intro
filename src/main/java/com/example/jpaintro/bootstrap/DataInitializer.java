package com.example.jpaintro.bootstrap;

import com.example.jpaintro.entity.Book;
import com.example.jpaintro.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args)  {
        bookRepository.deleteAll();
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
