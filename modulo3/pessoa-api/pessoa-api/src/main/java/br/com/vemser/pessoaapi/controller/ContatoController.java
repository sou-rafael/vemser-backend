package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
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


    @GetMapping
    public List<Contato> listarTodos() {
        return contatoService.listar();
    }

    @GetMapping("/{idPessoa}") // com variavel
    public List<Contato> listarIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listarIdPessoa(idPessoa);
    }

    // HW4===================================================================
    @PostMapping
    public Contato criar(@Valid @RequestBody ContatoDTO contato) throws RegraDeNegocioException {
        return contatoService.criar(contato);
    }

    @PutMapping("/{idContato}")
    public Contato editar(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoDTO contatoNovo) throws RegraDeNegocioException {

        return contatoService.editar(id, contatoNovo);
    }

    @DeleteMapping("/{idContato}")
    public void apagar(@PathVariable("idContato") Integer idContato) throws RegraDeNegocioException {
        contatoService.apagar(idContato);
    }
}
