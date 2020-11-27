package br.edu.fasam.tcc.renato.graphql;

import br.edu.fasam.tcc.renato.exceptions.BusinessException;
import br.edu.fasam.tcc.renato.interfaces.IService;
import br.edu.fasam.tcc.renato.model.Post;
import br.edu.fasam.tcc.renato.repository.PostRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostGraphQL implements IService<Post, Integer>, GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Post create(Post entity) {
        return postRepository.save(entity);
    }

    @Override
    public List<Post> read() {
        return postRepository.findAll();
    }

    @Override
    public Post read(Integer id) {
        return postRepository.findById(id).orElseThrow(()->new BusinessException());
    }

    @Override
    public Page<Post> read(String nome, Pageable pageable) {
        return postRepository.page(nome, pageable);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void update(Post entity) {
        postRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Post entity) {
        postRepository.delete(entity);
    }
}
