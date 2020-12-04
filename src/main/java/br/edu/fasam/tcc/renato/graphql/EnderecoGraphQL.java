package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.Author;
import br.edu.fasam.tcc.renato.service.AuthorService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class AuthorGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private AuthorService authorService;

    public Optional<Author> findAuthor(String email){
        return authorService.findAuthorByEmail(email);
    }

    @Transactional(rollbackOn = Exception.class)
    public Author createAuthor(Author author) {
        return authorService.create(author);
    }

}
