package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.PostQL
        ;
import br.edu.fasam.tcc.renato.service.PostQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class PostGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private PostQLService postQLService;

    public Optional<PostQL> findPost(Integer id){
        return postQLService.findPostQLById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public PostQL createPost(PostQL post) {
        return postQLService.create(post);
    }

}
