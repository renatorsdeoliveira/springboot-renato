package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Todo;
import br.edu.fasam.tcc.renato.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoService implements IService<Todo, Integer> {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Todo create(Todo entity) {
        return todoRepository.save(entity);
    }

    @Override
    public List<Todo> read() {
        return todoRepository.findAll();
    }

    @Override
    public Todo read(Integer id) {
        return todoRepository.findById(id).orElseThrow(()->new BusinessException("Não foi possível encontrar o registro solicitado"));
    }

    @Override
    public Page<Todo> read(String nome, Pageable pageable) {
        return todoRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Todo entity) {
        todoRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void patch(Todo entity) { todoRepository.save(entity); }


    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        todoRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Todo entity) {
        todoRepository.delete(entity);
    }
}
