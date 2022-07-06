import Entidades.Pessoa;
import Repositorio.RepositorioPessoa;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        RepositorioPessoa rp = new RepositorioPessoa();
        Pessoa pessoa = new Pessoa(1, "Rafael",30);
        rp.salvarPessoa(pessoa);
        pessoa = new Pessoa(2, "Tasia", 30);
        rp.salvarPessoa(pessoa);

//
//        if (salvo) {
//            System.out.println(pessoa.getNome() + " salvo com sucesso!");
//        }

        System.out.println(rp.listarPessoa());
        rp.deletarPessoaPorIndex(0);
        System.out.println("Apagando id0");

        System.out.println(rp.listarPessoa());


    }
//    static void listarPessoas() {
//        List<Pessoa> lista1 = new ArrayList<Pessoa>();
//        RepositorioPessoa rp = new RepositorioPessoa();
//
//        for(Pessoa pessoa : lista1){
//            System.out.println(pessoa.toString());
//            }
//
//        }

}
