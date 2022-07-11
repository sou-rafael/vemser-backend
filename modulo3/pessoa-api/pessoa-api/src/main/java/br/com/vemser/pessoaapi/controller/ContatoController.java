package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
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
    public List<ContatoDTO> listarTodos() throws RegraDeNegocioException {
        return contatoService.listar();
    }

    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listarIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return contatoService.listarIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ContatoDTO criar(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        return contatoService.criar(idPessoa, contato);
    }

    @PutMapping("/{idContato}")
    public ContatoDTO editar(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contatoNovo) throws RegraDeNegocioException {

        return contatoService.editar(id, contatoNovo);
    }

    @DeleteMapping("/{idContato}")
    public void apagar(@PathVariable("idContato") Integer idContato) throws RegraDeNegocioException {
        contatoService.apagar(idContato);
    }
}
