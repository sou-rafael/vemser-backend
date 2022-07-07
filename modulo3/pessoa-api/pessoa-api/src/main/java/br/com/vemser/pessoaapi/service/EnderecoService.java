package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
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

    public List<Endereco> listar(){
        return enderecoRepository.listar();
    }

    //GET /endereco/{idEndereco} -- recupera o endereco especifico

    public List<Endereco> listarIdEndereco(Integer idEndereco){
        return enderecoRepository.listarIdEndereco(idEndereco);
    }
    //GET /endereco/{idPessoa}/pessoa -- recupera endereços por pessoa

    public List<Endereco> listarEnderecoPorIdPessoa(Integer idPessoa){
        return enderecoRepository.listarEnderecoPorIdPessoa(idPessoa);
    }

    //POST /endereco/{idPessoa} -- recebe a pessoa, o endereco e cria o endereco com id da pessoa
    public Endereco criar(Integer idPessoa, @NotNull Endereco endereco) throws Exception{
        boolean pessoaExiste = enderecoRepository.listar().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
        if(pessoaExiste){
        return enderecoRepository.criar(idPessoa, endereco);}
        else throw new Exception("O endereco nao esta na lista.");
    }

    //PUT /endereco/{idEndereco} --  altera os dados do endereço.
    public Endereco editar(Integer idEndereco, Endereco enderecoNovo) throws Exception {
        boolean enderecoExiste = enderecoRepository.listar().stream()
                .anyMatch(end -> end.getIdEndereco().equals(idEndereco));
        if(enderecoExiste){
        return enderecoRepository.editar(idEndereco,enderecoNovo);
    }else throw new Exception("O endereco nao esta na lista");
    }

    //DELETE “/endereco/{idEndereco}” -- remove o endereço pelo id
    public void apagar(Integer idEndereco) throws Exception{
        enderecoRepository.apagar(idEndereco);
    }
}
