package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.TodoQL;
import br.edu.fasam.tcc.renato.service.TodoQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class TodoGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private TodoQLService todoQLService;

    public Optional<TodoQL> findTodo(Integer id){
        return todoQLService.findTodoQLById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public TodoQL createTodo(TodoQL todo) {
        return todoQLService.create(todo);
    }

}
