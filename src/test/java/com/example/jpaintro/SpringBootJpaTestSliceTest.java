package com.example.jpaintro;

import com.example.jpaintro.entity.Book;
import com.example.jpaintro.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.example.jpaintro.bootstrap"}) // bring DataInitializer
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // do not autoconfigure H2 DB
class SpringBootJpaTestSliceTest {

    @Autowired
    BookRepository bookRepository;

    @Order(1)
    @Commit // need this to force test to commit changes to DB. Same as @Rollback(value = false)
    @Test
    void testGpaTestSplice() {
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("my book", "12312", "self", null));
        long countAfter = bookRepository.count();

        assertThat(countBefore, is(lessThan(countAfter)));
    }

    @Order(2)
    @Test
    void testJpaSpliceTransaction() {
        long countBefore = bookRepository.count();

        assertThat(countBefore, is(equalTo(3L)));
    }
}
