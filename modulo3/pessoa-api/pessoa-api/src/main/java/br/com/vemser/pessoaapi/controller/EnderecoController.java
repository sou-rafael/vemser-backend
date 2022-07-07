package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

//    CONSTRUTOR
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listar(){return enderecoService.listar();}

    @GetMapping("/{idEndereco}")
    public List<Endereco> listarIdEndereco(@PathVariable("idEndereco") Integer idEndereco){
        return enderecoService.listarIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listarEnderecoPorIdPessoa(@PathVariable("idPessoa") Integer idPessoa){
        return enderecoService.listarEnderecoPorIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco criar(@PathVariable("idPessoa") Integer idPessoa, @RequestBody Endereco endereco) throws Exception {
        return enderecoService.criar(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco editar(@PathVariable Integer idEndereco, @RequestBody Endereco enderecoNovo) throws Exception {
        return enderecoService.editar(idEndereco, enderecoNovo);
    }

    @DeleteMapping("/{idEndereco}")
    public void apagar(@PathVariable Integer idEndereco) throws Exception{
        enderecoService.apagar(idEndereco);
    }
}
