package com.example.jpaintro;

import com.example.jpaintro.entity.AuthorUuid;
import com.example.jpaintro.entity.BookUuid;
import com.example.jpaintro.repository.AuthorUuidRepository;
import com.example.jpaintro.repository.BookRepository;
import com.example.jpaintro.repository.BookUuidRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.example.jpaintro.bootstrap"}) // bring DataInitializer
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // do not autoconfigure H2 DB
class MySqlIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookUuidRepository uuidRepository;

    @Autowired
    AuthorUuidRepository authorUuidRepository;
    @Autowired
    private BookUuidRepository bookUuidRepository;

    @Test
    void testBookRepository() {
        long countBefore = bookRepository.count();
        assertThat(countBefore, is(equalTo(2L)));
    }

    @Test
    void testBookUuidRepository() {
        long countBefore = bookUuidRepository.count();
        bookUuidRepository.save(new BookUuid());
        long countAfter = bookUuidRepository.count();
        assertThat(countBefore, is(equalTo(1L)));
        assertThat(countAfter, is(equalTo(2L)));
    }

    @Test
    void testAuthorUuidRepository() {
        long countBefore = authorUuidRepository.count();
        authorUuidRepository.save(new AuthorUuid());
        long countAfter = authorUuidRepository.count();
        assertThat(countBefore, is(equalTo(1L)));
        assertThat(countAfter, is(equalTo(2L)));
    }
}
