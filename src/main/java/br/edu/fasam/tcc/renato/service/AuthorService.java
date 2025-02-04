package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.Author;
import br.edu.fasam.tcc.renato.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
/*
 *Classe de negócio responsável para tratar informações referentes a author (Author)
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public void delete(Author author){
        authorRepository.delete(author);
    }

    public Optional<Author> findAuthorByEmail(String email) {
        return authorRepository.findByEmail(email);
    }
}
