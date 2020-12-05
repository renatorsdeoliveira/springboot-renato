package br.edu.fasam.tcc.renato.repository;

import br.edu.fasam.tcc.renato.interfaces.IRepository;
import br.edu.fasam.tcc.renato.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface AlbumRepository  extends IRepository<Album, Integer> {
    @Query(value="SELECT c from Album c WHERE c.title LIKE '%:descricao%'")
    Page<Album> page(@Param("descricao") String desricao, @Param("pageable") Pageable pageable);
}
