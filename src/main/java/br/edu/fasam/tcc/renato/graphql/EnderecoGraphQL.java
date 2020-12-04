package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.model.Endereco;
import br.edu.fasam.tcc.renato.service. EnderecoService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class EnderecoGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private EnderecoService enderecoService;

    public Optional<Endereco> findEndereco(Integer id){
        return enderecoService.findEnderecoById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public Endereco createEndereco(Endereco endereco) {
        return enderecoService.create(endereco);
    }

}
