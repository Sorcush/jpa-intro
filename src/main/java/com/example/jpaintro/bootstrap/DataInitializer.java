package com.example.jpaintro.bootstrap;

import com.example.jpaintro.entity.AuthorUuid;
import com.example.jpaintro.entity.Book;
import com.example.jpaintro.entity.BookUuid;
import com.example.jpaintro.repository.AuthorUuidRepository;
import com.example.jpaintro.repository.BookRepository;
import com.example.jpaintro.repository.BookUuidRepository;
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
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;

    @Override
    public void run(String... args)  {
        bookRepository.deleteAll();
        authorUuidRepository.deleteAll();
        bookUuidRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "Random House", null);
        Book savedDDD = bookRepository.save(bookDDD);
        log.info("Saved book: {}", savedDDD);


        Book bookSIA= new Book("Spring In Action", "123354234", "Oriel", null);
        Book savedSIA = bookRepository.save(bookSIA);
        log.info("Saved book: {}", savedSIA);

        for (Book book : bookRepository.findAll()) {
            log.info("Book found: {}", book);
        }

        AuthorUuid authorUuid = new AuthorUuid("John", "Smith");
        AuthorUuid savedAuthor = authorUuidRepository.save(authorUuid);
        log.info("Saved UUID author: {}", savedAuthor);

        BookUuid bookUuid = new BookUuid("Hobbit", "235235", "Home");
        BookUuid savedBook = bookUuidRepository.save(bookUuid);
        log.info("Saved UUID book: {}", savedBook);

    }
}
