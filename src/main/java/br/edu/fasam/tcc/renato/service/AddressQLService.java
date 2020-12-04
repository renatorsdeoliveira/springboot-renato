package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.AddressQL;
import br.edu.fasam.tcc.renato.repository.AddressQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressQLService {

    @Autowired
    private AddressQLRepository addressQLRepository;

    public AddressQL create(AddressQL address) {
        return addressQLRepository.save(address);
    }

    public void deleteDoRenato(AddressQL address){
        addressQLRepository.delete(address);
    }

    public Optional<AddressQL> findAddressQLById(Integer id) {
        return addressQLRepository.findById(id);
    }
}
