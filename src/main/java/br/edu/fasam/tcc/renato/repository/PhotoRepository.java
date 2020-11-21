package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.interfaces.IRepository;
import br.edu.fasam.tcc.renato.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface PhotoRepository extends IRepository<Photo, Integer> {


    @Query(value="SELECT c from Photo c WHERE c.title LIKE '%:descricao%'")
    Page<Photo> page(@Param("descricao") String desricao, @Param("pageable") Pageable pageable);

}
