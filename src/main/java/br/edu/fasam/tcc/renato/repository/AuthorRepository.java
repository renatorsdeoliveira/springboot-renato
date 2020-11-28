package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByEmail(String email);
}
