package br.edu.fasam.tcc.renato.controller;

import br.edu.fasam.tcc.renato.interfaces.IController;
import br.edu.fasam.tcc.renato.model.Geo;
import br.edu.fasam.tcc.renato.service.GeoService;
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
@Api(value="Operações para manipulação dos dados de geo", tags = "geo, geos")
@RequestMapping(value = "/api/geos", path = "/api/geos")
public class GeoController extends DefaultController implements IController<Geo, Integer> {

    @Autowired
    private GeoService geoService;

    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.geo-post}", notes="Criar dados do geo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Geo.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Geo.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Geo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Geo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Geo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Geo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Geo.class)
    })
    public ResponseEntity<?> create(@Valid @RequestBody Geo entity) {

        log.trace("Criando objeto geo. {}", entity);
        Geo geo = geoService.create(entity);
        HttpHeaders responseHttpHeaders = getHttpHeaders(geo.getId());

        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHttpHeaders).body(geo);

    }



    @Override
    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.geo-get-id}", notes="Exibe dados do geo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Geo.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Geo.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Geo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Geo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Geo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Geo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Geo.class)
    })
    public ResponseEntity<?> read(@PathVariable Integer id) {

        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        log.debug(String.format("Método: %s | Parâmetro: %d",methodName, id));

        log.trace("Buscanco comentáro por identificador: {}", id);
        Geo geo = geoService.read(id);
        HttpHeaders responseHttpHeaders = getHttpHeaders(geo.getId());

        return ResponseEntity.ok().headers(responseHttpHeaders).body(geo);

    }



    @Override
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="${controller.geo-get}", notes="Exibe dados do geo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Geo.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Geo.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Geo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Geo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Geo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Geo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Geo.class)
    })
    public ResponseEntity<?> read(@RequestParam("descricao") String descricao,
                                  @RequestParam(defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "20") Integer size) {


        Page<Geo> list = geoService.read(descricao, PageRequest.of(page, size));

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
    @ApiOperation(value="${controller.geo-put}", notes="Atualizar dados do geo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Geo.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Geo.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Geo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Geo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Geo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Geo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Geo.class)
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Geo entity) {
        log.trace("Alterando registro {}", entity);
        //Atuliza o registro
        geoService.update(entity);
        //Fazer tratativas de retorno correto HTTP
        HttpHeaders responseHeaders = getHttpHeaders(null);
        //Retornar a consulta com o cabeçalho correto
        return ResponseEntity.noContent().headers(responseHeaders).build();
    }



    @Override
    @PatchMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiOperation(value="${controller.geo-patch}", notes="Atualizar dados do geo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Geo.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Geo.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Geo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Geo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Geo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Geo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Geo.class)
    })
    public ResponseEntity<?> patch(@PathVariable Integer id, @Valid @RequestBody Geo entity) {
        log.trace("Alterando registro {}", entity);
        //Atuliza o registro
        geoService.patch(entity);
        //Fazer tratativas de retorno correto HTTP
        HttpHeaders responseHeaders = getHttpHeaders(null);
        //Retornar a consulta com o cabeçalho correto
        return ResponseEntity.noContent().headers(responseHeaders).build();
    }



    @Override
    @DeleteMapping(path = "/{id}")
    @ApiOperation(value="${controller.geo-delete}", notes="Exlcuir dados do geo.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Geo.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Geo.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Geo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Geo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Geo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Geo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Geo.class)
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        //Exclusao do comentário
        geoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



    @Override
    @RequestMapping(method={RequestMethod.OPTIONS}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value="${controller.geo-options}", notes="Método responsável para apresentar as operações que o geo pode fazer da API utilizada.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Geo.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Geo.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo.", response = Geo.class),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Geo.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Geo.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Geo.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Geo.class)
    })
    public ResponseEntity<?> options() {
        return ResponseEntity.status(200)
                .allow(HttpMethod.POST, HttpMethod.GET, HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.OPTIONS)
                .body(String.format("Métodos permitidos: %s", Arrays.asList("GET", "POST","PUT","PATCH","DELETE", "OPTIONS").toString()));
    }
}
