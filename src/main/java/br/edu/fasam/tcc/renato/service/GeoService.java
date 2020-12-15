package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Geo;
import br.edu.fasam.tcc.renato.repository.GeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
 *Classe de negócio responsável para tratar informações referentes a geo (Geo)
 */
@Service
public class GeoService implements IService<Geo, Integer> {

    @Autowired
    private GeoRepository geoRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Geo create(Geo entity) {
        return geoRepository.save(entity);
    }

    @Override
    public List<Geo> read() {
        return geoRepository.findAll();
    }

    @Override
    public Geo read(Integer id) {
        return geoRepository.findById(id).orElseThrow(()->new BusinessException("Não foi possível encontrar o registro solicitado"));
    }

    @Override
    public Page<Geo> read(String nome, Pageable pageable) {
        return geoRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Geo entity) {
        geoRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void patch(Geo entity) {
        geoRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        geoRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Geo entity) {
        geoRepository.delete(entity);
    }


}
