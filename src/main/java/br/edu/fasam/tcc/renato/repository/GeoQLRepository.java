package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.GeoQL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeoQLRepository extends JpaRepository<GeoQL, Long> {
    Optional<GeoQL> findById(Integer id);
}
