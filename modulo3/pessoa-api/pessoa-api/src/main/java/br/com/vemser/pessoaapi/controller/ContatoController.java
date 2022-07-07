package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<Contato> listarTodos() {
        return contatoService.listar();
    }

    @GetMapping("/{idPessoa}") // com variavel
    public List<Contato> listarIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listarIdPessoa(idPessoa);
    }
    /*@GetMapping("/{idPessoa}") // com ?query
    public List<Contato> listarIdPessoa(@PathVariable("idPessoa")Integer idPessoa) {
        return contatoService.listarIdPessoa(idPessoa);
    }*/

    @PostMapping
    public Contato criar(@RequestBody Contato contato) throws Exception {
        return contatoService.criar(contato);
    }

    @PutMapping("/{idContato}")
    public Contato editar(@PathVariable("idContato") Integer id, @RequestBody Contato contatoNovo) throws Exception {

        return contatoService.editar(id, contatoNovo);
    }

    @DeleteMapping("/{idContato}")
    public void apagar(@PathVariable("idContato") Integer idContato) throws Exception {
        contatoService.apagar(idContato);
    }
}
