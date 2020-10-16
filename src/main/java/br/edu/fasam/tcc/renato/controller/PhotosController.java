package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Photos;
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
@Api(value="Operações para manipulação dos dados de photos", tags = "photos, fotos, photo, foto")
@RequestMapping(value = "/api/photos", path = "/api/photos")
public class PhotosController implements IController<Photos, Integer> {

    @Override
    public ResponseEntity<?> create(Photos entity) {
        return null;
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.photo-get}", notes="Exibe dados de photos.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro entregue com sucesso.", response = Photos.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photos.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photos.class)
    })
    public ResponseEntity<?> read(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> read(String descricao, Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Integer id, Photos entity) {
        return null;
    }

    @Override
    public ResponseEntity<?> patch(Integer id, Photos entity) {
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
