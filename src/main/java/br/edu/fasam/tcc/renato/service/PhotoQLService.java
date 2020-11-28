package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.PhotoQL;
import br.edu.fasam.tcc.renato.repository.PhotoQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotoQLService {

    @Autowired
    private PhotoQLRepository photoQLRepository;

    public PhotoQL create(PhotoQL photoQL) {
        return photoQLRepository.save(photoQL);
    }

    public void deleteDoRenato(PhotoQL photoQL){
        photoQLRepository.delete(photoQL);
    }

    public Optional<PhotoQL> findPhotoQLById(Integer id) {
        return photoQLRepository.findById(id);
    }
}
