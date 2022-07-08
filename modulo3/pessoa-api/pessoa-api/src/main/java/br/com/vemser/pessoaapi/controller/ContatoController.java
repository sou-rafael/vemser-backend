package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
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
    public Contato criar(@Valid @RequestBody Contato contato) throws Exception {
        return contatoService.criar(contato);
    }

    @PutMapping("/{idContato}")
    public Contato editar(@PathVariable("idContato") Integer id, @Valid @RequestBody Contato contatoNovo) throws Exception {

        return contatoService.editar(id, contatoNovo);
    }

    @DeleteMapping("/{idContato}")
    public void apagar(@PathVariable("idContato") Integer idContato) throws Exception {
        contatoService.apagar(idContato);
    }
}
