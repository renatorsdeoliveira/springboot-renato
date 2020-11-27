package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.User;
import br.edu.fasam.tcc.renato.service.UserService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGraphQL implements IService<User, Integer>, GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public User read(Integer id) {
        return null;
    }

    @Override
    public Page<User> read(String nome, Pageable pageable) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void delete(User entity) {

    }
}
