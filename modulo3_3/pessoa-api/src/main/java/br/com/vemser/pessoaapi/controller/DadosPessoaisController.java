package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.vemser.pessoaapi.service.DadosPessoaisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/dados-pessoais")
@Validated
@Slf4j
public class DadosPessoaisController implements DadosPessoaisClient {
    @Autowired
    private DadosPessoaisService dadosPessoaisService;
    @Override
    @GetMapping
    public List<DadosPessoaisDTO> getAll() {
        return dadosPessoaisService.getAll();
    }

    @Override
    @PostMapping
    public DadosPessoaisDTO post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.post(dadosPessoaisDTO);
    }

    @Override
    @PutMapping("/{cpf}")
    public DadosPessoaisDTO put(@PathVariable("cpf") String cpf,@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisService.put(cpf, dadosPessoaisDTO);
    }

    @Override
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisService.delete(cpf);
    }

    @Override
    @GetMapping("/{cpf}")
    public DadosPessoaisDTO get(@PathVariable("cpf") String cpf) {
        return dadosPessoaisService.get(cpf);
    }
}
