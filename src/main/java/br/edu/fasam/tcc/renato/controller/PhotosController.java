package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Photo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="Operações para manipulação dos dados de photos", tags = "photos, fotos, photo, foto")
@RequestMapping(value = "/api/photos", path = "/api/photos")
public class PhotosController implements IController<Photo, Integer> {

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.photo-post}", notes="Criar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> create(Photo entity) {
        return null;
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.photo-get}", notes="Exibe dados de photos.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro entregue com sucesso.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
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
    @ApiOperation(value="${controller.photo-put}", notes="Atualizar dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> update(Integer id, Photo entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> patch(Integer id, Photo entity) {
        return null;
    }

    @Override
    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.photo-delete}", notes="Exlcuir dados do usuário.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro excluído com sucesso.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> options() {
        return null;
    }
}
