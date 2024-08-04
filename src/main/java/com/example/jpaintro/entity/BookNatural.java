package com.example.jpaintro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookNatural {

    @Id
    private String title;
    private String isbn;
    private String publisher;
}
