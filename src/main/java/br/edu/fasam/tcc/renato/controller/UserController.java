package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value="Operações para manipulação dos dados do usuário", tags = "usuario, user, usuário")
@RequestMapping(value = "/api/users", path = "/api/users")
public class UserController implements IController<User, Integer> {
    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.user-post}", notes="Criar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = User.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = User.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = User.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = User.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = User.class)
    })
    public ResponseEntity<?> create(User entity) {
        return null;
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.user-get}", notes="Exibe dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro entregue com sucesso.", response = User.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = User.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = User.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = User.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = User.class)
    })
    public ResponseEntity<?> read(Integer id) {
        return null;
    }

    @Override
//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ApiOperation(value="${controller.user-get-id}", notes="Exibe dados do usuário.")
//    @ApiResponses(value={
//            @ApiResponse(code = 200, message = "Registro entregue com sucesso.", response = User.class),
//            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = User.class),
//            @ApiResponse(code = 401, message = "Não autorizado.", response = User.class),
//            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = User.class)
//    })
    public ResponseEntity<?> read(String descricao, Integer page, Integer size) {
        return null;
    }

    @Override
    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.user-put}", notes="Atualizar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = User.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = User.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = User.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = User.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = User.class)
    })
    public ResponseEntity<?> update(Integer id, User entity) {
        return null;
    }

    @Override

    public ResponseEntity<?> patch(Integer id, User entity) {
        return null;
    }

    @Override
    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.user-delete}", notes="Exlcuir dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro excluído com sucesso.", response = User.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = User.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = User.class)
    })
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> options() {
        return null;
    }
}
