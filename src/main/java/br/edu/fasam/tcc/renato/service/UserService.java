package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IService<User, Integer> {

    @Override
    @Transactional(rollbackFor = Throwable.class)
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
    @Transactional(rollbackFor = Throwable.class)
    public void update(User entity) {

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(User entity) {

    }
}
