package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.interfaces.IRepository;
import br.edu.fasam.tcc.renato.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface TodoRepository extends IRepository<Comment, Integer> {


    @Query(value="SELECT c from Comment c WHERE c.body LIKE '%:descricao%'")
    Page<Comment> page(@Param("descricao") String desricao, @Param("pageable") Pageable pageable);

}
