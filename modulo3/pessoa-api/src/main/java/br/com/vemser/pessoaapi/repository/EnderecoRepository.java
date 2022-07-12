package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import br.com.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private EnderecoService enderecoService = new EnderecoService();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.COMERCIAL, "rua qualquer", 12, "", "64000111", "Teresina", "Piaui", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "rua torta", 354, "", "64000333", "Teresina", "Piaui", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.COMERCIAL, "avenida das normalistas", 8461, "", "64002177", "Sao Luis", "Maranhao", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.RESIDENCIAL, "rua escura", 11552, "", "64022121", "Sao Luis", "Maranhao", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.COMERCIAL, "rua clara", 186, "", "54000219", "Joao Pessoa", "Paraiba", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.RESIDENCIAL, "avenida dos Ipes", 978, "", "24500118", "Joao Pessoa", "Paraiba", "Brasil"));
    }

    public List<Endereco> listar() {
        return listaEnderecos;
    }

    public List<Endereco> listarIdEndereco(Integer idEndereco) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    public List<Endereco> listarEnderecoPorIdPessoa(Integer idPessoa) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public Endereco criar(Integer idPessoa, EnderecoCreateDTO enderecoOrig) {
        Endereco endereco = enderecoService.covertToEndereco(enderecoOrig);
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listaEnderecos.add(endereco);
        return endereco;
    }

    public Endereco editar(Integer idEndereco, EnderecoCreateDTO enderecoNovoOrig) {
        Endereco enderecoNovo = enderecoService.covertToEndereco(enderecoNovoOrig);
        Endereco enderecoAtual = new Endereco();

        enderecoAtual.setIdEndereco(idEndereco);
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

    public void apagar(Integer idEndereco) {
        Endereco endRemover = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst().get();
        listaEnderecos.remove(endRemover);
        log.info("Apagou");
    }
}
