package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Comment;
import br.edu.fasam.tcc.renato.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;


@Log4j2
@RestController
@Api(value="Operações para manipulação dos dados do comments", tags = "comment, comments")
@RequestMapping(value = "/api/comments", path = "/api/comments")
public class CommentController extends DefaultController implements IController<Comment, Integer> {

    @Autowired
    private CommentService commentService;

    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-post}", notes="Criar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Comment.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comment.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comment.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comment.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comment.class)
    })
    public ResponseEntity<?> create(@Valid @RequestBody Comment entity) {

        log.trace("Criando objeto comment. {}", entity);
        Comment comment = commentService.create(entity);
        HttpHeaders responseHttpHeaders = getHttpHeaders(comment.getId());

        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHttpHeaders).body(comment);

    }



    @Override
    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.comment-get-id}", notes="Exibe dados do comments.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Comment.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comment.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comment.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comment.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comment.class)
    })
    public ResponseEntity<?> read(@PathVariable Integer id) {

        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        log.debug(String.format("Método: %s | Parâmetro: %d",methodName, id));

        log.trace("Buscanco comentáro por identificador: {}", id);

        Comment comment = commentService.read(id);
        HttpHeaders responseHttpHeaders = getHttpHeaders(comment.getId());

        return ResponseEntity.ok().headers(responseHttpHeaders).body(comment);
    }



    @Override
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.comment-get}", notes="Exibe dados do comments.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Comment.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comment.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comment.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comment.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comment.class)
    })
    public ResponseEntity<?> read(@RequestParam("descricao") String descricao,
                                  @RequestParam(defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "20") Integer size) {

        Page<Comment> list = commentService.read(descricao, PageRequest.of(page, size));

        //Usar método herdado para fazer paginação
        ResponseHeaderPaginable responseHeaderPaginable = new ResponseHeaderPaginable(page,list);
        //Calcula o tamanho da página
        responseHeaderPaginable.invoke();
        //Controla o status de saída HTTP da aplicação
        HttpStatus status = responseHeaderPaginable.getStatus();
        //Retorna a lista pagina para o cliente com o HTTP STATUS e HEADERS corretos
        return ResponseEntity
                .status(status)
                .header(CONTENT_RANGE_HEADER, responseHeaderPaginable.responsePageRange()).body(list);
    }



    @Override
    @PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value="${controller.comment-put}", notes="Atualizar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Comment.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comment.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comment.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comment.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comment.class)
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Comment entity) {

        log.trace("Alterando registro {}", entity);

        //Atuliza o registro
        commentService.update(entity);
        //Fazer tratativas de retorno correto HTTP
        HttpHeaders responseHeaders = getHttpHeaders(null);
        //Retornar a consulta com o cabeçalho correto
        return ResponseEntity.noContent().headers(responseHeaders).build();
    }



    @Override
    @PatchMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value="${controller.comment-patch}", notes="Atualizar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Comment.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comment.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comment.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comment.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comment.class)
    })
    public ResponseEntity<?> patch(@PathVariable Integer id, @Valid @RequestBody Comment entity) {

        log.trace("Alterando registro {}", entity);

        //Atuliza o registro
        commentService.patch(entity);
        //Fazer tratativas de retorno correto HTTP
        HttpHeaders responseHeaders = getHttpHeaders(null);
        //Retornar a consulta com o cabeçalho correto
        return ResponseEntity.noContent().headers(responseHeaders).build();
    }



    @Override
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value="${controller.comment-delete}", notes="Exlcuir dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Comment.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comment.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comment.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comment.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comment.class)
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        //Exclusao do comentário
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.comment-options}", notes="Método responsável para apresentar as operações que o usuário pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Comment.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Comment.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Comment.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Comment.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Comment.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200)
                .allow(HttpMethod.POST, HttpMethod.GET, HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.OPTIONS)
                .body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","PATCH","DELETE", "OPTIONS").toString()));
    }
}
