package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.PhotoQL;
import br.edu.fasam.tcc.renato.service.PhotoQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class PhotoGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private PhotoQLService photoQLService;

    public Optional<PhotoQL> findPhoto(Integer id){
        return photoQLService.findPhotoQLById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public PhotoQL createPhoto(PhotoQL photo) {
        return photoQLService.create(photo);
    }

}
