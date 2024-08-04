package com.example.jpaintro.entity.composite;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "author_composite")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorEmbedded {

    @EmbeddedId
    private NameId nameId;

    private String country;
}