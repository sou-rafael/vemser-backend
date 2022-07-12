package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
@Slf4j
public class PessoaController {
    @Autowired
    public PropertieReader propertieReader;
    @Autowired
    private PessoaService pessoaService;

    //    ******************** exemplos da aula *********************************************
    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello World 2!";
    }

    @GetMapping("/checkEmail")
    public String checkEmail() { return propertieReader.getEmail(); }

    @GetMapping("/{ambiente}")
    public String getAmbiente() {
        return propertieReader.getAmbiente();
    }
//  **************************************************************************************

    @GetMapping
    public List<PessoaDTO> list() throws RegraDeNegocioException {
        return pessoaService.list();
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) throws RegraDeNegocioException {
        return pessoaService.listByName(nome);
    }


    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @PostMapping
    public PessoaDTO create(@RequestBody PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return pessoaService.create(pessoa);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }
}
