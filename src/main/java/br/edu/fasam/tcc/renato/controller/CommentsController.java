package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Comments;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value="Operações para manipulação dos dados do comments", tags = "comments, comentários, comment,  comentário")
@RequestMapping(value = "/api/comments", path = "/api/comments")
public class CommentsController implements IController<Comments, Integer> {


    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-post}", notes="Criar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Comments.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comments.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comments.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comments.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comments.class)
    })
    public ResponseEntity<?> create(Comments entity) {
        return null;
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-get}", notes="Exibe dados do comments.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro entregue com sucesso.", response = Comments.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comments.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comments.class)
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
    @ApiOperation(value="${controller.comment-put}", notes="Atualizar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Comments.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comments.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comments.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comments.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comments.class)
    })
    public ResponseEntity<?> update(Integer id, Comments entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> patch(Integer id, Comments entity) {
        return null;
    }

    @Override
    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-delete}", notes="Exlcuir dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro excluído com sucesso.", response = Comments.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comments.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comments.class)
    })
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> options() {
        return null;
    }
}
