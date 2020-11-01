package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService implements IService<Post, Integer> {

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Post create(Post entity) {
        return null;
    }

    @Override
    public List<Post> read() {
        return null;
    }

    @Override
    public Post read(Integer id) {
        return null;
    }

    @Override
    public Page<Post> read(String nome, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Post entity) {

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional(rollbackFor =  Throwable.class)
    public void delete(Post entity) {

    }
}
