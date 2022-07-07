package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {
    @Autowired
    public PropertieReader propertieReader;
    @Autowired
    private PessoaService pessoaService;

//    public PessoaController(){ pessoaService = new PessoaService();}

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello World 2!";
    }

    // ***********************************************************************************
    @GetMapping("/{ambiente}")
    public String getAmbiente() {
        return propertieReader.getAmbiente();
    }
//    **************************************************************************************

    @PostMapping
    public Pessoa create(@Valid @RequestBody Pessoa pessoa) throws Exception{
            return pessoaService.create(pessoa);
    }


    @GetMapping // localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }
}
