package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.CommentQL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentQLRepository extends JpaRepository<CommentQL, Long> {
    Optional<CommentQL> findByEmail(String email);
}
