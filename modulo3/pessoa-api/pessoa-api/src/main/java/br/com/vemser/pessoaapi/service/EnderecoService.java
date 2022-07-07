package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    //verificar necessidade de construtor

    //GET /endereco -- listar todos

    public List<Endereco> listar() {
        return enderecoRepository.listar();
    }

    //GET /endereco/{idEndereco} -- recupera o endereco especifico

    public List<Endereco> listarIdEndereco(Integer idEndereco) {
        return enderecoRepository.listarIdEndereco(idEndereco);
    }
    //GET /endereco/{idPessoa}/pessoa -- recupera endereços por pessoa

    public List<Endereco> listarEnderecoPorIdPessoa(Integer idPessoa) {
        return enderecoRepository.listarEnderecoPorIdPessoa(idPessoa);
    }

    //POST /endereco/{idPessoa} -- recebe a pessoa, o endereco e cria o endereco com id da pessoa
    public Endereco criar(Integer idPessoa, Endereco endereco) throws Exception {
        boolean pessoaExiste = enderecoRepository.listar().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
        boolean logradouroEmBranco = StringUtils.isBlank(endereco.getLogradouro());

        if (pessoaExiste && !logradouroEmBranco) {
            return enderecoRepository.criar(idPessoa, endereco);
        } else throw new Exception("O endereco nao eh valido ou nao esta na lista.");
    }

    //PUT /endereco/{idEndereco} --  altera os dados do endereço.
    public Endereco editar(Integer idEndereco, Endereco enderecoNovo) throws Exception {
//        ******* testar usando abstração
//        boolean enderecoExiste = enderecoRepository.listar().stream()
//                .anyMatch(end -> end.getIdEndereco().equals(idEndereco));
        if (objetoExiste(idEndereco)) {
            return enderecoRepository.editar(idEndereco, enderecoNovo);
        } else throw new Exception("O endereco nao esta na lista");
    }
    public boolean objetoExiste(Integer id) {
        boolean objetoExiste = enderecoRepository.listar().stream()
                .anyMatch(end -> end.getIdEndereco().equals(id));
        return objetoExiste;
    }

    //DELETE “/endereco/{idEndereco}” -- remove o endereço pelo id
    public void apagar(Integer idEndereco) throws Exception {
        enderecoRepository.apagar(idEndereco);
    }

    //    testando abstração -- usando em editar

}
