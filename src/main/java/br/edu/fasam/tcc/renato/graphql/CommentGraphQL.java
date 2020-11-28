package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.CommentQL;
import br.edu.fasam.tcc.renato.service.CommentQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class CommentGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private CommentQLService commentQLService;

    public Optional<CommentQL> findComment(String email){
        return commentQLService.findAuthorByEmail(email);
    }

    @Transactional(rollbackOn = Exception.class)
    public CommentQL createComment(CommentQL comment) {
        return commentQLService.create(comment);
    }

}
