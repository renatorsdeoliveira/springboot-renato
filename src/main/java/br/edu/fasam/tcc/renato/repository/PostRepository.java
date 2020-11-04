package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.interfaces.IRepository;
import br.edu.fasam.tcc.renato.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface PostRepository extends IRepository<Post, Integer> {


    @Query(value="SELECT c from Post c WHERE c.body LIKE '%:descricao%'")
    Page<Post> page(@Param("descricao") String desricao, @Param("pageable") Pageable pageable);

}
