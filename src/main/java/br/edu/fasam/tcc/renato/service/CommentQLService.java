package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.CommentQL;
import br.edu.fasam.tcc.renato.repository.CommentQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentQLService {

    @Autowired
    private CommentQLRepository commentQLRepository;

    public CommentQL create(CommentQL commentQL) {
        return commentQLRepository.save(commentQL);
    }

    public void deleteDoRenato(CommentQL commentQL){
        commentQLRepository.delete(commentQL);
    }

    public Optional<CommentQL> findAuthorByEmail(String email) {
        return commentQLRepository.findByEmail(email);
    }
}
