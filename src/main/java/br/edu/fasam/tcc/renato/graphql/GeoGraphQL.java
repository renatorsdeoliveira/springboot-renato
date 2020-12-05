package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.GeoQL;
import br.edu.fasam.tcc.renato.service.GeoQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class GeoGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private GeoQLService geoQLService;

    public Optional<GeoQL> findGeo(Integer id){
        return geoQLService.findGeoQLById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public GeoQL createGeo(GeoQL geoQL) {
        return geoQLService.create(geoQL);
    }

}
