package com.example.jpaintro.repository;

import com.example.jpaintro.entity.composite.AuthorEmbedded;
import com.example.jpaintro.entity.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
