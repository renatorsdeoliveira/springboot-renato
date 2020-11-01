package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhotoService implements IService<Photo, Integer> {

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Photo create(Photo entity) {
        return null;
    }

    @Override
    public List<Photo> read() {
        return null;
    }

    @Override
    public Photo read(Integer id) {
        return null;
    }

    @Override
    public Page<Photo> read(String nome, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Photo entity) {

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Photo entity) {

    }
}
