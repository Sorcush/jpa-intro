package com.example.jpaintro.entity.composite;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@IdClass(NameId.class)
public class AuthorComposite {

    @Id
    private String firstName;

    @Id
    private String lastName;

    private String country;
}
