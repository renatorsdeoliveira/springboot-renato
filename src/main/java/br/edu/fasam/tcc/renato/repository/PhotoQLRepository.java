package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.PhotoQL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhotoQLRepository extends JpaRepository<PhotoQL, Long> {
    Optional<PhotoQL> findById(Integer id);
}
