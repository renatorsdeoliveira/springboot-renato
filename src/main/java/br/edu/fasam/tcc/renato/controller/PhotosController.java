package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Photo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@Api(value="Operações para manipulação dos dados de photos", tags = "photos, fotos, photo, foto")
@RequestMapping(value = "/api/photos", path = "/api/photos")
public class PhotosController implements IController<Photo, Integer> {

    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.photo-post}", notes="Criar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> create(@Valid @RequestBody Photo entity) {
        return null;
    }

    @Override
    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.photo-get-id}", notes="Exibe dados do comments.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> read(@PathVariable Integer id) {
        return null;
    }

    @Override
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.photo-get}", notes="Exibe dados do comments.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> read(@RequestParam("descricao") String descricao,
                                  @RequestParam(defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "20") Integer size) {
        return null;
    }

    @Override
    @PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value="${controller.photo-put}", notes="Atualizar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Photo entity) {
        return null;
    }

    @Override
    @PatchMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value="${controller.photo-patch}", notes="Atualizar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> patch(@PathVariable Integer id, @Valid @RequestBody Photo entity) {
        return null;
    }

    @Override
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value="${controller.photo-delete}", notes="Exlcuir dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return null;
    }

    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.photo-options}", notes="Método responsável para apresentar as operações que o usuário pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200).body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","PATCH","DELETE", "OPTIONS").toString()));
    }
}
