package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.TodoQL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoQLRepository extends JpaRepository<TodoQL, Long> {
    Optional<TodoQL> findById(Integer id);
}
