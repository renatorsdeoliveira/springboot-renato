package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.PostQL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostQLRepository extends JpaRepository<PostQL, Long> {
    Optional<PostQL> findById(Integer id);
}
