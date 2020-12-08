package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Address;
import br.edu.fasam.tcc.renato.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService implements IService<Address, Integer> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Address create(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public List<Address> read() {
        return addressRepository.findAll();
    }

    @Override
    public Address read(Integer id) {
        return addressRepository.findById(id).orElseThrow(()->new BusinessException("Não foi possível encontrar o registro solicitado"));
    }

    @Override
    public Page<Address> read(String nome, Pageable pageable) {
        return addressRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Address entity) {
        addressRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void patch(Address entity) {
        addressRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Address entity) {
        addressRepository.delete(entity);
    }


}
