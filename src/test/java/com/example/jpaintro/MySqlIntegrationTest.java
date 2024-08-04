package com.example.jpaintro;

import com.example.jpaintro.entity.AuthorUuid;
import com.example.jpaintro.entity.BookNatural;
import com.example.jpaintro.entity.BookUuid;
import com.example.jpaintro.entity.composite.AuthorComposite;
import com.example.jpaintro.entity.composite.AuthorEmbedded;
import com.example.jpaintro.entity.composite.NameId;
import com.example.jpaintro.repository.*;
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

    @Autowired
    private AuthorCompositeRepository authorCompositeRepository;

    @Autowired
    private AuthorEmbeddedRepository authorEmbeddedRepository;

    @Autowired
    private BookNaturalRepository bookNaturalRepository;

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

    @Test
    void testBookNaturalRepository() {
        long countBefore = bookNaturalRepository.count();
        bookNaturalRepository.save(new BookNatural("LTR", "23423", "Audio"));
        long countAfter = bookNaturalRepository.count();
        assertThat(countBefore, is(equalTo(0L)));
        assertThat(countAfter, is(equalTo(1L)));
    }

    @Test
    void testAuthorCompositeRepository() {
        long countBefore = authorCompositeRepository.count();
        AuthorComposite saved = authorCompositeRepository.save(new AuthorComposite("Alex", "Jones", "Canada"));
        long countAfter = authorCompositeRepository.count();
        AuthorComposite fetched = authorCompositeRepository.getReferenceById(new NameId(saved.getFirstName(), saved.getLastName()));

        assertThat(countBefore, is(equalTo(0L)));
        assertThat(countAfter, is(equalTo(1L)));
        assertThat(fetched.getFirstName(), is(equalTo("Alex")));
        assertThat(fetched.getLastName(), is(equalTo("Jones")));
    }

    @Test
    void testAuthorEmbeddedRepository() {
        long countBefore = authorEmbeddedRepository.count();
        AuthorEmbedded saved = authorEmbeddedRepository.save(new AuthorEmbedded(new NameId("Alex1", "Jones1"), "Canada"));
        long countAfter = authorEmbeddedRepository.count();
        AuthorEmbedded fetched = authorEmbeddedRepository.getReferenceById(new NameId(saved.getNameId().getFirstName(), saved.getNameId().getLastName()));

        assertThat(countBefore, is(equalTo(0L)));
        assertThat(countAfter, is(equalTo(1L)));
        assertThat(fetched.getNameId().getFirstName(), is(equalTo("Alex1")));
        assertThat(fetched.getNameId().getLastName(), is(equalTo("Jones1")));
    }
}
