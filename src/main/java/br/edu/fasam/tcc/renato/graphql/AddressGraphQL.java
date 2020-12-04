package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.AddressQL;
import br.edu.fasam.tcc.renato.service.AddressQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class AddressGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private AddressQLService addressQLService;

    public Optional<AddressQL> findAddress(Integer id){
        return addressQLService.findAddressQLById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public AddressQL createAddress(AddressQL address) {
        return addressQLService.create(address);
    }

}
