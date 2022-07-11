package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
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

//    public EnderecoController(EnderecoService enderecoService) {
//        this.enderecoService = enderecoService;
//    }

    @GetMapping
    public List<EnderecoDTO> listar() {
        return enderecoService.listar();
    }

    @GetMapping("/{idEndereco}")
    public List<EnderecoDTO> listarIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        return enderecoService.listarIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listarEnderecoPorIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return enderecoService.listarEnderecoPorIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoDTO criar(@Valid @PathVariable("idPessoa") Integer idPessoa,@Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return enderecoService.criar(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public EnderecoDTO editar(@PathVariable("idEndereco") Integer idEndereco,@Valid @RequestBody EnderecoCreateDTO enderecoNovo) throws RegraDeNegocioException {
        return enderecoService.editar(idEndereco, enderecoNovo);
    }

    @DeleteMapping("/{idEndereco}")
    public void apagar(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.apagar(idEndereco);
    }
}
