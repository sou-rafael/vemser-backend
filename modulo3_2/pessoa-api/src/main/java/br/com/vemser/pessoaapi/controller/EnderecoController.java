package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    //*********************************************************************************************************************************
    @Operation(summary = "Listar todos os endereços", description = "Lista todos os endereços cadastrados em todos as pessoas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listagem com sucesso."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception.")
            }
    )
    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    //*********************************************************************************************************************************
    @Operation(summary = "Exibe um endereço específico", description = "Exibe um endereço espeficicado por seu id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Exibido com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception.")
            }
    )
    @GetMapping("/{idEndereco}")
    public List<EnderecoDTO> listIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        return enderecoService.listEnderecoPorId(idEndereco);
    }

//    @Operation(summary = "Listar os endereços filtrando por pessoa", description = "Lista todos os endereços cadastrados por pessoa informada.")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(responseCode = "200", description = "Listagem com sucesso."),
//                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
//                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception.")
//            }
//    )
//    @GetMapping("/{idPessoa}/pessoa")
//    public List<EnderecoDTO> listEnderecoPorIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
//        return enderecoService.listEnderecoPorIdPessoa(idPessoa);
//    }

    //*********************************************************************************************************************************
    @Operation(summary = "Criar um novo endereço e envia um email de confirmação", description = "Cria um novo endereço, atribui a uma pessoa especificada e envia um email de confirmação.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço criado com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception.")
            }
    )
    @PostMapping("/{idPessoa}")
    public EnderecoDTO criar(@Valid @PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return enderecoService.create(idPessoa, endereco);
    }

    //*********************************************************************************************************************************
    @Operation(summary = "Editar endereço específico e envia um email de confirmação", description = "Atualiza determinado endereço especificado e envia um email de confirmação.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualizado com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception.")
            }
    )
    @PutMapping("/{idEndereco}")
    public EnderecoDTO editar(@PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoCreateDTO enderecoNovo) throws RegraDeNegocioException {
        return enderecoService.update(idEndereco, enderecoNovo);
    }

    //*********************************************************************************************************************************
    @Operation(summary = "Apagar endereço especifico e envia um email de confirmação", description = "Deleta um endereço especifico e envia um email de confirmação.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deletado com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Erro de Cliente, verificar os argumentos."),
                    @ApiResponse(responseCode = "500", description = "Erro de Servidor, foi gerada uma Exception.")
            }
    )
    @DeleteMapping("/{idEndereco}")
    public void apagar(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.delete(idEndereco);
    }
}
