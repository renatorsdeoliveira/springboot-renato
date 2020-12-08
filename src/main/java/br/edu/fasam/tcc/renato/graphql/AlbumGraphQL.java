package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.Album;
import br.edu.fasam.tcc.renato.service.AlbumService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AlbumGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private AlbumService albumService;

    public Album findAlbum(Integer id){
        return albumService.read(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public Album createAlbum(Album album) {
        return albumService.create(album);
    }

}
