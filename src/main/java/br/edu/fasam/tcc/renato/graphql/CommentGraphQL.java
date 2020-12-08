package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.Comment;
import br.edu.fasam.tcc.renato.service.CommentService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CommentGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private CommentService commentService;

    public Comment findComment(Integer id){ return commentService.read(id); }

    @Transactional(rollbackOn = Exception.class)
    public Comment createComment(Comment comment) {
        return commentService.create(comment);
    }

}
