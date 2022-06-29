package Repositorio;

import Entidades.Pessoa;

import java.util.List;

public interface IRepositorioPessoa {

    boolean salvarPessoa(Pessoa pessoa);
    boolean deletarPessoaPorIndex(int id);
    List<Pessoa> listarPessoa();
    boolean alterarPessoa(Pessoa pessoa);

}
