package br.edu.fasam.tcc.renato.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Interface genérica para comada de repositório
 *
 * @param <T>
 * @param <N>
 */
public interface IRepository<T, N> extends JpaRepository<T, N>, JpaSpecificationExecutor<T> {

    Optional<T> findById(N id);

}
