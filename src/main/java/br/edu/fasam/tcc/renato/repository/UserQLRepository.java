package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.UserQL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserQLRepository extends JpaRepository<UserQL, Long> {
    Optional<UserQL> findByEmail(String email);
}
