package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.Photo;
import br.edu.fasam.tcc.renato.service.PhotoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class PhotoGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private PhotoService photoService;

    public Photo findPhoto(Integer id){
        return photoService.read(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public Photo createPhoto(Photo photo) {
        return photoService.create(photo);
    }

}
