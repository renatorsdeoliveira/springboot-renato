package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.Post
        ;
import br.edu.fasam.tcc.renato.service.PostService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class PostGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private PostService postService;

    public Post findPost(Integer id){
        return postService.read(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public Post createPost(Post post) {
        return postService.create(post);
    }

}
