package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.TodoQL;
import br.edu.fasam.tcc.renato.repository.TodoQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoQLService {

    @Autowired
    private TodoQLRepository todoQLRepository;

    public TodoQL create(TodoQL todoQL) {
        return todoQLRepository.save(todoQL);
    }

    public void deleteDoRenato(TodoQL todoQL){
        todoQLRepository.delete(todoQL);
    }

    public Optional<TodoQL> findTodoQLById(Integer id) {
        return todoQLRepository.findById(id);
    }
}
