package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    //********************* Exercicios Aula4 **************************
    @GetMapping("/contatos-order-descricao")
    public Page<ContatoEntity> contatosOrdByDescricao(@RequestParam Integer pagina, @RequestParam Integer quantidadeRegistos) {
        Sort ordenado = Sort.by("descricao");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistos, ordenado);
        return contatoRepository.findAll(pageable);
    }

    @GetMapping("/enderecos-order-cep")
    public Page<EnderecoEntity> enderecosOrdByCep(@RequestParam Integer pagina, @RequestParam Integer quantidadeRegistos) {
        Sort ordem = Sort.by("cep");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistos, ordem);
        return enderecoRepository.findAll(pageable);
    }

    ;

    @GetMapping("/enderecos/{pais}")
    public Page<EnderecoEntity> enderecosFilterPais(@PathVariable("pais") String pais, @RequestParam Integer pagina, @RequestParam Integer quantidadeRegistos) {
        Sort ordem = Sort.by("pais");
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistos, ordem);
        List<EnderecoEntity> enderecoEntities = enderecoRepository.findAll(pageable).stream()
                .filter(endereco -> endereco.getPais().toUpperCase().contains(pais.toUpperCase()))
                .toList();
        return (Page<EnderecoEntity>) enderecoEntities;
    }

    ;

}
