package com.example.jpaintro;

import com.example.jpaintro.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest
class JpaIntroApplicationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testBookRepository() {
        long count = bookRepository.count();

        assertThat(count, is(greaterThan(0L)));
    }

    @Test
    void contextLoads() {
    }

}
