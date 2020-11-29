package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.AlbumQL;
import br.edu.fasam.tcc.renato.repository.AlbumQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumQLService {

    @Autowired
    private AlbumQLRepository albumQLRepository;

    public AlbumQL create(AlbumQL albumQL) {
        return albumQLRepository.save(albumQL);
    }

    public void deleteDoRenato(AlbumQL albumQL){
        albumQLRepository.delete(albumQL);
    }

    public Optional<AlbumQL> findPostQLById(Integer id) {
        return albumQLRepository.findById(id);
    }
}
