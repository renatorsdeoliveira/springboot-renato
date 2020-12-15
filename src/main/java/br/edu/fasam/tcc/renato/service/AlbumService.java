package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Album;
import br.edu.fasam.tcc.renato.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
 *Classe de negócio responsável para tratar informações referentes a album (Album)
 */
@Service
public class AlbumService implements IService<Album, Integer> {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Album create(Album entity) {
        return albumRepository.save(entity);
    }

    @Override
    public List<Album> read() {
        return albumRepository.findAll();
    }

    @Override
    public Album read(Integer id) {
        return albumRepository.findById(id).orElseThrow(()->new BusinessException("Não foi possível encontrar o registro solicitado"));
    }

    @Override
    public Page<Album> read(String nome, Pageable pageable) {
        return albumRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Album entity) {
        albumRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void patch(Album entity) {
        albumRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        albumRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Album entity) {
        albumRepository.delete(entity);
    }


}
