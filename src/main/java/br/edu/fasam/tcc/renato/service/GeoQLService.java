package br.edu.fasam.tcc.renato.service;

import br.edu.fasam.tcc.renato.model.GeoQL;
import br.edu.fasam.tcc.renato.repository.GeoQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeoQLService {

    @Autowired
    private GeoQLRepository geoQLRepository;

    public GeoQL create(GeoQL geoQL) {
        return geoQLRepository.save(geoQL);
    }

    public void deleteDoRenato(GeoQL geoQL){
        geoQLRepository.delete(geoQL);
    }

    public Optional<GeoQL> findGeoQLById(Integer id) {
        return geoQLRepository.findById(id);
    }
}
