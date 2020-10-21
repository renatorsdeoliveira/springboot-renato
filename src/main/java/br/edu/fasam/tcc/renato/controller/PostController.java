package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Post;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="Operações para manipulação dos dados do post", tags = "post, posts")
@RequestMapping(value = "/api/posts", path = "/api/posts")
public class PostController implements IController<Post, Integer> {

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.post-post}", notes="Criar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Post.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Post.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Post.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Post.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Post.class)
    })
    public ResponseEntity<?> create(Post entity) {
        return null;
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.post-get}", notes="Exibe dados do post.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro entregue com sucesso.", response = Post.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Post.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Post.class)
    })
    public ResponseEntity<?> read(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> read(String descricao, Integer page, Integer size) {
        return null;
    }

    @Override
    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.post-put}", notes="Atualizar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Post.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Post.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Post.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Post.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Post.class)
    })
    public ResponseEntity<?> update(Integer id, Post entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> patch(Integer id, Post entity) {
        return null;
    }

    @Override
    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.post-delete}", notes="Exlcuir dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro excluído com sucesso.", response = Post.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Post.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Post.class)
    })
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> options() {
        return null;
    }
    
}
