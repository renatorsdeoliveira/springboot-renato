package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.interfaces.IRepository;
import br.edu.fasam.tcc.renato.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface TodoRepository extends IRepository<Todo, Integer> {


    @Query(value="SELECT c from Todo c WHERE c.title LIKE '%:descricao%'")
    Page<Todo> page(@Param("descricao") String desricao, @Param("pageable") Pageable pageable);

}
