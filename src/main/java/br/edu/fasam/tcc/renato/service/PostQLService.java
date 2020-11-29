package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.PostQL;
import br.edu.fasam.tcc.renato.repository.PostQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostQLService {

    @Autowired
    private PostQLRepository postQLRepository;

    public PostQL create(PostQL postQL) {
        return postQLRepository.save(postQL);
    }

    public void deleteDoRenato(PostQL postQL){
        postQLRepository.delete(postQL);
    }

    public Optional<PostQL> findPostQLById(Integer id) {
        return postQLRepository.findById(id);
    }
}
