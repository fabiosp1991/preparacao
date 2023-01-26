package br.com.fabiosp1991.preparacao.controllers;

import br.com.fabiosp1991.preparacao.dtos.ImovelDto;
import br.com.fabiosp1991.preparacao.entities.ImovelEntity;
import br.com.fabiosp1991.preparacao.repositories.ImovelRepository;
import br.com.fabiosp1991.preparacao.services.ImovelService;
import br.com.fabiosp1991.preparacao.utils.DataResponsePresenter;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Serviço para aplicação para preparação de sobrevivencialistas", tags = "preparacao-resources")
public class ImovelController {


    @Autowired
     ImovelService imovelService;


    @ApiOperation(value = "Serviço para obter imovel através do apelido do imóvel",
            nickname = "imovelApelido",
            notes = "Serviço para obter imovel através do apelido do imóvel",
            authorizations = {@Authorization(value = "JWT")})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @GetMapping("/imovel/find/{apelido}")
    public ResponseEntity<ImovelDto> getImovelApelido(@PathVariable String apelido) {
        return new ResponseEntity<>(imovelService.getImovelApelido(apelido), HttpStatus.OK);
    }

    @ApiOperation(value = "Serviço para criar um novo imovel",
            nickname = "imovelApelido",
            notes = "Serviço para obter imovel através do apelido do imóvel",
            authorizations = {@Authorization(value = "JWT")})
    @ApiResponses(value = {@ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @PostMapping("/imovel/new")
    public ResponseEntity<ImovelDto> saveImovel(@RequestBody @NonNull @Valid ImovelDto imovelDto) {
        return new ResponseEntity<>(imovelService.saveImovel(imovelDto), HttpStatus.CREATED);
    }
}
