package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.UserQL;
import br.edu.fasam.tcc.renato.service.UserQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private UserQLService userQLService;

    public Optional<UserQL> findUser(String email) {
        return userQLService.findUser(email);
    }

    public UserQL createUser(UserQL user, Integer id) {
        return userQLService.create(user, id);
    }

}
