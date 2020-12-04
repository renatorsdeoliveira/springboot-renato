package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.AddressQL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressQLRepository extends JpaRepository<AddressQL, Long> {
    Optional<AddressQL> findById(Integer id);
}
