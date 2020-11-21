package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Comment;
import br.edu.fasam.tcc.renato.service.CommentService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentGraphQL implements IService<Comment, Integer>,
        GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    CommentService commentService;

    @Override
    public Comment create(Comment entity) {
        return commentService.create(entity);
    }

    @Override
    public List<Comment> read() {
        return null;
    }

    @Override
    public Comment read(Integer id) {
        return null;
    }

    @Override
    public Page<Comment> read(String nome, Pageable pageable) {
        return null;
    }

    @Override
    public void update(Comment entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void delete(Comment entity) {

    }
}
