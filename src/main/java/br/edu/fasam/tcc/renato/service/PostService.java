package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Post;
import br.edu.fasam.tcc.renato.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
 *Classe de negócio responsável para tratar informações referentes a post (Post)
 */
@Service
public class PostService implements IService<Post, Integer> {
    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Post create(Post entity) {
        return postRepository.save(entity);
    }

    @Override
    public List<Post> read() {
        return postRepository.findAll();
    }

    @Override
    public Post read(Integer id) {
        return postRepository.findById(id).orElseThrow(()->new BusinessException("Não foi possível encontrar o registro solicitado"));
    }

    @Override
    public Page<Post> read(String nome, Pageable pageable) {
        return postRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Post entity) {
        postRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void patch(Post entity) {
        postRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor =  Throwable.class)
    public void delete(Post entity) {
        postRepository.delete(entity);
    }
}
