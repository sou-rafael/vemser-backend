package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.DadosCompletosDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosCompletosService {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    public void dadosCompletosDTOListar () throws RegraDeNegocioException {
//        pessoaService.list()+enderecoService.listar()+contatoService.listar()+dadosPessoaisService.getAll();
    } 
}
