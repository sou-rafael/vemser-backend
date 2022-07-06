package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.service.ContatoService;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private ContatoService contatoService;

    public ContatoController() {contatoService = new ContatoService();}

    @GetMapping
    public List<Contato> listartodos() {
        return contatoService.listar();
    }
    @GetMapping("/{idPessoa}") // com variavel
    public List<Contato> listarIdPessoa(@PathVariable("idPessoa")Integer idPessoa) {
        return contatoService.listarIdPessoa(idPessoa);
    }
    /*@GetMapping("/{idPessoa}") // com ?query
    public List<Contato> listarIdPessoa(@PathVariable("idPessoa")Integer idPessoa) {
        return contatoService.listarIdPessoa(idPessoa);
    }*/

    @PostMapping
    public Contato criar(@RequestBody Contato contato) {
        return contatoService.criar(contato);
    }

    @PutMapping("/{idContato}")
    public Contato editar(@PathVariable("idContato") Integer id, @RequestBody Contato contatoNovo) throws Exception {
        return contatoService.editar(id, contatoNovo);
    }

    @DeleteMapping("/{idContato}")
    public void apagar(@PathVariable("idContato")Integer idContato) throws Exception{
        contatoService.apagar(idContato);
    }
}
