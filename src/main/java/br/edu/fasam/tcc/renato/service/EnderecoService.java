package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.Endereco;
import br.edu.fasam.tcc.renato.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteDoRenato(Endereco endereco){
        enderecoRepository.delete(endereco);
    }

    public Optional<Endereco> findEnderecoById(Integer id) {
        return enderecoRepository.findById(id);
    }
}
