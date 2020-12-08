package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.Todo;
import br.edu.fasam.tcc.renato.service.TodoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TodoGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private TodoService todoService;

    public Todo findTodo(Integer id){
        return todoService.read(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public Todo createTodo(Todo todo) {
        return todoService.create(todo);
    }

}
