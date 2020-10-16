package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Todos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="Operações para manipulação dos dados de todos", tags = "todos")
@RequestMapping(value = "/api/todos", path = "/api/todos")
public class TodosController implements IController<Todos, Integer> {
    @Override
    public ResponseEntity<?> create(Todos entity) {
        return null;
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.todo-get}", notes="Exibe dados de todos.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro entregue com sucesso.", response = Todos.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Todos.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Todos.class)
    })
    public ResponseEntity<?> read(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> read(String descricao, Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Integer id, Todos entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> patch(Integer id, Todos entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> options() {
        return null;
    }
}
