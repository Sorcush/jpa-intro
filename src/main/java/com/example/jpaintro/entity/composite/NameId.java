package com.example.jpaintro.entity.composite;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class NameId implements Serializable {
    private String firstName;
    private String lastName;
}
