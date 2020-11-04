package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Todo;
import br.edu.fasam.tcc.renato.service.TodoService;
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
@Api(value="Operações para manipulação dos dados de todos", tags = "todos")
@RequestMapping(value = "/api/todos", path = "/api/todos")
public class TodoController extends  DefaultController implements IController<Todo, Integer> {

    @Autowired
    private TodoService todoService;

    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.todo-post}", notes="Criar dados do todo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Todo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Todo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Todo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Todo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Todo.class)
    })
    public ResponseEntity<?> create(@Valid @RequestBody Todo entity) {
        log.trace("Criando objeto todo. {}", entity);
        Todo todo = todoService.create(entity);
        HttpHeaders responseHttpHeaders = getHttpHeaders(todo.getId());

        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHttpHeaders).body(todo);
    }

    @Override
    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.todo-get-id}", notes="Exibe dados do todo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Todo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Todo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Todo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Todo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Todo.class)
    })
    public ResponseEntity<?> read(@PathVariable Integer id) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        log.debug(String.format("Método: %s | Parâmetro: %d",methodName, id));

        log.trace("Buscanco comentáro por identificador: {}", id);

        Todo todo = todoService.read(id);
        HttpHeaders responseHttpHeaders = getHttpHeaders(todo.getId());

        return ResponseEntity.ok().headers(responseHttpHeaders).body(todo);
    }

    @Override
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.todo-get}", notes="Exibe dados do todo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Todo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Todo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Todo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Todo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Todo.class)
    })
    public ResponseEntity<?> read(@RequestParam("descricao") String descricao,
                                  @RequestParam(defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "20") Integer size) {


        Page<Todo> list = todoService.read(descricao, PageRequest.of(page, size));

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
    @ApiOperation(value="${controller.todo-put}", notes="Atualizar dados do todo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Todo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Todo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Todo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Todo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Todo.class)
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Todo entity) {
        log.trace("Alterando registro {}", entity);

        //Atuliza o registro
        todoService.update(entity);
        //Fazer tratativas de retorno correto HTTP
        HttpHeaders responseHeaders = getHttpHeaders(null);
        //Retornar a consulta com o cabeçalho correto
        return ResponseEntity.noContent().headers(responseHeaders).build();
    }


    @Override
    @PatchMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value="${controller.todo-patch}", notes="Atualizar dados do todo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Todo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Todo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Todo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Todo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Todo.class)
    })
    public ResponseEntity<?> patch(@PathVariable Integer id, @Valid @RequestBody Todo entity) {
        return null;
    }

    @Override
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value="${controller.todo-delete}", notes="Exlcuir dados do todo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Todo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Todo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Todo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Todo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Todo.class)
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        //Exclusao do comentário
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.todo-options}", notes="Método responsável para apresentar as operações que o usuário pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Todo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Todo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Todo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Todo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Todo.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200)
                .allow(HttpMethod.POST, HttpMethod.GET, HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.OPTIONS)
                .body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","PATCH","DELETE", "OPTIONS").toString()));
    }
}
