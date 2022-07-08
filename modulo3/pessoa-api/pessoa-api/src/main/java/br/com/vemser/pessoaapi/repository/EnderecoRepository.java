package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.COMERCIAL, "rua qualquer", 12, "", "64000111", "Teresina", "Piaui", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "rua torta", 354, "", "64000333", "Teresina", "Piaui", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.COMERCIAL, "avenida das normalistas", 8461, "", "64002177", "Sao Luis", "Maranhao", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.RESIDENCIAL, "rua escura", 11552, "", "64022121", "Sao Luis", "Maranhao", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.COMERCIAL, "rua clara", 186, "", "54000219", "Joao Pessoa", "Paraiba", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.RESIDENCIAL, "avenida dos Ipes", 978, "", "24500118", "Joao Pessoa", "Paraiba", "Brasil"));
    }

    //GET /endereco -- listar todos
    public List<Endereco> listar() {
        return listaEnderecos;
    }

    //GET /endereco/{idEndereco} -- recupera o endereco especifico
    public List<Endereco> listarIdEndereco(Integer idEndereco) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    //GET /endereco/{idPessoa}/pessoa -- recupera endereços por pessoa
    public List<Endereco> listarEnderecoPorIdPessoa(Integer idPessoa) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    //POST /endereco/{idPessoa} -- recebe a pessoa, o endereco e cria o endereco com id da pessoa
    public Endereco criar(Integer idPessoa, Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listaEnderecos.add(endereco);
        return endereco;
    }

    //PUT /endereco/{idEndereco} --  altera os dados do endereço.
    public Endereco editar(Integer idEndereco, Endereco enderecoNovo) throws Exception {
        Endereco enderecoAtual = new Endereco();
        enderecoAtual.setIdPessoa(enderecoNovo.getIdPessoa());
        enderecoAtual.setTipo(enderecoNovo.getTipo());
        enderecoAtual.setLogradouro(enderecoNovo.getLogradouro());
        enderecoAtual.setNumero(enderecoNovo.getNumero());
        enderecoAtual.setComplemento(enderecoNovo.getComplemento());
        enderecoAtual.setCep(enderecoNovo.getCep());
        enderecoAtual.setCidade(enderecoNovo.getCidade());
        enderecoAtual.setEstado(enderecoNovo.getEstado());
        enderecoAtual.setPais(enderecoNovo.getPais());

        return enderecoAtual;
    }

    //DELETE “/endereco/{idEndereco}” -- remove o endereço pelo id
    public void apagar(Integer idEndereco) throws Exception {
    }
}