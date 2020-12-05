package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Comment;
import br.edu.fasam.tcc.renato.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Classe de negócio responsável para tratar informações referente a comentários (Comment);
 */
@Service
public class CommentService implements IService<Comment, Integer> {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Comment create(Comment entity) {
        return commentRepository.save(entity);
    }

    @Override
    public List<Comment> read() {
        return commentRepository.findAll();
    }

    @Override
    public Comment read(Integer id) {
        return commentRepository.findById(id).orElseThrow(()->new BusinessException("Não foi possível encontrar o registro solicitado"));
    }

    @Override
    public Page<Comment> read(String nome, Pageable pageable) {
        return commentRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Comment entity) {
        commentRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void patch(Comment entity) {
        commentRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Comment entity) {
        commentRepository.delete(entity);
    }
}
