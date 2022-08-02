package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.documentations.PessoaDocs;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.RelatorioPersonalizadoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.service.ContatoService;
import br.com.vemser.pessoaapi.service.EnderecoService;
import br.com.vemser.pessoaapi.service.PessoaService;
import br.com.vemser.pessoaapi.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
@RequiredArgsConstructor
public class PessoaController implements PessoaDocs {
    @Autowired
    public PropertieReader propertieReader;
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private PetService petService;


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

    @PostMapping // obs.: como estou criando uma pessoa nova, nao preciso tratar
    public PessoaDTO create(@RequestBody PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return pessoaService.create(pessoa);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }

    //*******************************************
    @GetMapping("/listar-com-enderecos")
    public List<PessoaDTO> listarPessoaEEndereco(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listarComEnderecos(idPessoa);
    }

    @GetMapping("/listar-com-contatos")
    public List<PessoaDTO> listarComContatos(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listarComContatos(idPessoa);
    }

    @GetMapping("/listar-com-pets")
    public List<PessoaDTO> listarComPets(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listarComPets(idPessoa);
    }

    //*******************************************
    @GetMapping("/relatorio-pessoa")
    public Page<RelatorioPersonalizadoDTO> listarRelatorioPessoa(@RequestParam(required = false) Integer idPessoa,
                                                                 @RequestParam Integer pagina,
                                                                 @RequestParam Integer quantRegistros) {
        return pessoaService.listarRelatorioPessoa(idPessoa, pagina, quantRegistros);
    }

    @GetMapping("/pessoa-completo")
    public List<PessoaDTO> listarPessoaCompleto(@RequestParam(required = false) Integer idPessoa) {
        return pessoaService.listarPessoaCompleto(idPessoa);
    }


}
