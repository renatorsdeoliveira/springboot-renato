package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Photo;
import br.edu.fasam.tcc.renato.service.PhotoService;
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
@Api(value="Operações para manipulação dos dados de photos", tags = "photo, photos")
@RequestMapping(value = "/api/photos", path = "/api/photos")
public class PhotoController extends DefaultController implements IController<Photo, Integer> {

    @Autowired
    private PhotoService photoService;

    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.photo-post}", notes="Criar dados do photo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro criado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> create(@Valid @RequestBody Photo entity) {

        log.trace("Criando objeto photo. {}", entity);
        Photo photo = photoService.create(entity);
        HttpHeaders responseHttpHeaders = getHttpHeaders(photo.getId());

        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHttpHeaders).body(photo);

    }

    @Override
    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.photo-get-id}", notes="Exibe dados do photo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> read(@PathVariable Integer id) {

        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        log.debug(String.format("Método: %s | Parâmetro: %d",methodName, id));

        log.trace("Buscanco comentáro por identificador: {}", id);
        Photo photo = photoService.read(id);
        HttpHeaders responseHttpHeaders = getHttpHeaders(photo.getId());

        return ResponseEntity.ok().headers(responseHttpHeaders).body(photo);

    }

    @Override
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.photo-get}", notes="Exibe dados do photo.")
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


        Page<Photo> list = photoService.read(descricao, PageRequest.of(page, size));

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
    @ApiOperation(value="${controller.photo-put}", notes="Atualizar dados do photo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Photo entity) {
        log.trace("Alterando registro {}", entity);
        //Atuliza o registro
        photoService.update(entity);
        //Fazer tratativas de retorno correto HTTP
        HttpHeaders responseHeaders = getHttpHeaders(null);
        //Retornar a consulta com o cabeçalho correto
        return ResponseEntity.noContent().headers(responseHeaders).build();
    }

    @Override
    @PatchMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value="${controller.photo-patch}", notes="Atualizar dados do photo.")
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
    @ApiOperation(value="${controller.photo-delete}", notes="Exlcuir dados do photo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        //Exclusao do comentário
        photoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.photo-options}", notes="Método responsável para apresentar as operações que o photo pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Registro atualizado com sucesso.", response = Photo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Photo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Photo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Photo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Photo.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200)
                .allow(HttpMethod.POST, HttpMethod.GET, HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.OPTIONS)
                .body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","PATCH","DELETE", "OPTIONS").toString()));
    }
}
