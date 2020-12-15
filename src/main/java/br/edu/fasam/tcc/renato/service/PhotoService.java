package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Photo;
import br.edu.fasam.tcc.renato.repository.PhotoRepository;
import br.edu.fasam.tcc.renato.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
 *Classe de negócio responsável para tratar informações referentes a posts (Post)
 */
@Service
public class PhotoService implements IService<Photo, Integer> {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Photo create(Photo entity) {
        return photoRepository.save(entity);
    }

    @Override
    public List<Photo> read() {
        return photoRepository.findAll();
    }

    @Override
    public Photo read(Integer id) {
        return photoRepository.findById(id).orElseThrow(()->new BusinessException("Não foi possível encontrar o registro solicitado"));
    }

    @Override
    public Page<Photo> read(String nome, Pageable pageable) {
        return photoRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Photo entity) {
        photoRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void patch(Photo entity) {
        photoRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        photoRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Photo entity) {
        photoRepository.delete(entity);
    }
}
