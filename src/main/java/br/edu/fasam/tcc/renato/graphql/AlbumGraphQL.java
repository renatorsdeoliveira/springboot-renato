package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.AlbumQL;
import br.edu.fasam.tcc.renato.service.AlbumQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class AlbumGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private AlbumQLService albumQLService;

    public Optional<AlbumQL> findAlbum(Integer id){
        return albumQLService.findPostQLById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public AlbumQL createAlbum(AlbumQL album) {
        return albumQLService.create(album);
    }

}
