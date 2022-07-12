package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
@Slf4j
public class PessoaController {
    @Autowired
    public PropertieReader propertieReader;
    @Autowired
    private PessoaService pessoaService;

//    ******************** exemplos da aula *********************************************
 /*
    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello World 2!";
    }

    @GetMapping("/checkEmail")
    public String checkEmail() { return propertieReader.getEmail(); }

    @GetMapping("/{ambiente}")
    public String getAmbiente() {
        return propertieReader.getAmbiente();
    }
    */
//  **************************************************************************************
    @Operation(summary = "Listar pessoa", description = "Lista todas as pessoas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @GetMapping
    public List<PessoaDTO> list() throws RegraDeNegocioException {
        return pessoaService.list();
    }

    @Operation(summary = "Listar pessoas por nome", description = "Lista pessoas por nome ou trechos de nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna as pessoas que possuem o nome ou trecho informado."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) throws RegraDeNegocioException {
        return pessoaService.listByName(nome);
    }
    //*********************************************************************************************************************************
    @Operation(summary = "Atualizar dados da pessoa e envia um email de confirmação", description = "Atualiza todos os dados da pessoa e envia um email de confirmação")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualizado com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        return pessoaService.update(id, pessoaAtualizar);
    }
    //*********************************************************************************************************************************
    @Operation(summary = "Cria uma nova pessoa e envia um email de confirmação", description = "Insere uma nova pessoa e envia um email de confirmação")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa criada com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @PostMapping
    public PessoaDTO create(@RequestBody PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return pessoaService.create(pessoa);
    }
    //*********************************************************************************************************************************
    @Operation(summary = "Apagar uma pessoa e envia um email de confirmação", description = "Apaga uma pessoa especificada por id e envia um email de confirmação")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa apagada com sucesso."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }
}
