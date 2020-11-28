package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.AlbumQL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumQLRepository extends JpaRepository<AlbumQL, Long> {
    Optional<AlbumQL> findById(Integer id);
}
