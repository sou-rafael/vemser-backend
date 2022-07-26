package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DadosPessoaisService implements DadosPessoaisClient {

    private final DadosPessoaisClient dadosPessoaisClient;

    @Override
    public List<DadosPessoaisDTO> getAll() {
        List<DadosPessoaisDTO> lista = this.dadosPessoaisClient.getAll();
        return lista;
    }

    @Override
    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return this.dadosPessoaisClient.post(dadosPessoaisDTO);

    }

    @Override
    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return this.dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    @Override
    public void delete(String cpf) {
        this.dadosPessoaisClient.delete(cpf);
    }

    @Override
    public DadosPessoaisDTO get(String cpf) {
        return this.dadosPessoaisClient.get(cpf);
    }
}
