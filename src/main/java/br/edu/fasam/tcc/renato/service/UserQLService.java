package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.UserQL;
import br.edu.fasam.tcc.renato.repository.UserQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQLService {

    @Autowired
    private UserQLRepository userQLRepository;

    @Autowired
    private AddressQLService addressQLService;

    public UserQL create(UserQL userQL, Integer id){
        userQL.setAddress(addressQLService.findAddressQLById(id).get());
        return userQLRepository.save(userQL);
    }

    public Optional<UserQL> findUser(String email) {
        return userQLRepository.findByEmail(email);
    }

}
