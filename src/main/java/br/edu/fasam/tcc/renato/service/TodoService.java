package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoService implements IService<Todo, Integer> {

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Todo create(Todo entity) {
        return null;
    }

    @Override
    public List<Todo> read() {
        return null;
    }

    @Override
    public Todo read(Integer id) {
        return null;
    }

    @Override
    public Page<Todo> read(String nome, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Todo entity) {

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Todo entity) {

    }
}
