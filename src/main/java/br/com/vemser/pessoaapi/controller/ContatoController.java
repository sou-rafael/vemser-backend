package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;


    //*********************************************************************************************************************************
    @Operation(summary = "Lista todos os contatos", description = "Listagem completa de todos os contatos.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listagem com sucesso."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @GetMapping
    public List<ContatoDTO> listarTodos() throws RegraDeNegocioException {
        return contatoService.list();
    }

    @Operation(summary = "Lista os contatos da pessoa.", description = "Listagem dos contatos de uma pessoa especificada.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listagem com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listContatoPorIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return contatoService.listContatoPorIdPessoa(idPessoa);
    }
    //*********************************************************************************************************************************
    @Operation(summary = "Cria um contato para uma pessoa e envia um email de confirmação.", description = "Cria um novo contato, atribui a uma pessoa especificada e envia um email de confirmação.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "ContatoEntity criado com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        return contatoService.create(idPessoa, contato);
    }
    //*********************************************************************************************************************************
    @Operation(summary = "Atualiza um contato especifico e envia um email de confirmação.", description = "Atualiza um contato especificado pelo seu id e envia um email de confirmação.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "ContatoEntity atualizado com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contatoNovo) throws RegraDeNegocioException {

        return contatoService.update(id, contatoNovo);
    }
    //*********************************************************************************************************************************
    @Operation(summary = "Apaga um contato especifico e envia um email de confirmação.", description = "Apaga um contato especificado pelo seu id e envia um email de confirmação.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "ContatoEntity deletado com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception."),
            }
    )
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws RegraDeNegocioException {
        contatoService.delete(idContato);
    }
}
