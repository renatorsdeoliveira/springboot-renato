package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findById(Integer id);
}
