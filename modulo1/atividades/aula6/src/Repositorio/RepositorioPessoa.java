package Repositorio;

import Entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPessoa  implements IRepositorioPessoa {

    List<Pessoa> listaPessoas = new ArrayList<>();

    @Override
    public boolean salvarPessoa(Pessoa pessoa) {
        try {
            listaPessoas.add(pessoa);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deletarPessoaPorIndex(int id) {
        try {
            listaPessoas.remove(id);
        } catch (Exception e) {
            return false;
        }return true;
    }

    @Override
    public List<Pessoa> listarPessoa() {
        return listaPessoas;
    }

    @Override
    public boolean alterarPessoa(Pessoa pessoa) {
        return false;
    }
}
