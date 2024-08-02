package com.example.jpaintro;

import com.example.jpaintro.repository.BookRepository;
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

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore, is(equalTo(2L)));
    }

}
