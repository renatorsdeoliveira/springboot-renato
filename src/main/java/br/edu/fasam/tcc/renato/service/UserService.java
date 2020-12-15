package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.User;
import br.edu.fasam.tcc.renato.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
 *Classe de negócio responsável para tratar informações referentes a user (User)
 */
@Service
public class UserService implements IService<User, Integer> {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public User create(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public List<User> read() {
        return userRepository.findAll();
    }

    @Override
    public User read(Integer id) {
        return userRepository.findById(id).orElseThrow(()->new BusinessException("Não foi possível encontrar o registro solicitado"));
    }

    @Override
    public Page<User> read(String nome, Pageable pageable) {
        return userRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(User entity) {
        userRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void patch(User entity) {
        userRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(User entity) {
        userRepository.delete(entity);
    }
}
