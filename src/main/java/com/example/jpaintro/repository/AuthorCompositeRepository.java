package com.example.jpaintro.repository;

import com.example.jpaintro.entity.composite.AuthorComposite;
import com.example.jpaintro.entity.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
