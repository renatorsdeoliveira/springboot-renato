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
    private EnderecoService enderecoService;

    public UserQL create(UserQL usuario, Integer id){
        usuario.setEndereco(enderecoService.findEnderecoById(id).get());
        return userQLRepository.save(usuario);
    }

    public Optional<UserQL> findUsuario(String email) {
        return userQLRepository.findByEmail(email);
    }

}
