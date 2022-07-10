package br.com.vemser.pessoaapi.controller;

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
    public List<Endereco> listar() {
        return enderecoService.listar();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listarIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
        return enderecoService.listarIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listarEnderecoPorIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listarEnderecoPorIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco criar(@PathVariable("idPessoa") Integer idPessoa,@Valid @RequestBody Endereco endereco) throws RegraDeNegocioException {
        return enderecoService.criar(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco editar(@PathVariable("idEndereco") Integer idEndereco,@Valid @RequestBody Endereco enderecoNovo) throws RegraDeNegocioException {
        return enderecoService.editar(idEndereco, enderecoNovo);
    }

    @DeleteMapping("/{idEndereco}")
    public void apagar(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.apagar(idEndereco);
    }
}
