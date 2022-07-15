import exercicio2.entitys.Praia;
import exercicio2.entitys.PraiaBrava;
import exercicio2.entitys.PraiaCalma;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Praia> praias = new ArrayList<>();

        PraiaCalma praiaCalma1 = new PraiaCalma();
        praiaCalma1.setNome("Praia de Atalaia");
        praiaCalma1.setExtensao(300);
        praiaCalma1.setPodeLevarAnimais(true);

        PraiaCalma praiaCalma2 = new PraiaCalma();
        praiaCalma2.setNome("Praia do Coqueiro");
        praiaCalma2.setExtensao(200);
        praiaCalma2.setPodeLevarAnimais(true);

        PraiaBrava praiaBrava1 = new PraiaBrava();
        praiaBrava1.setNome("Praia do Futuro");
        praiaBrava1.setExtensao(500);
        praiaBrava1.setQuantidadeDeOndasPorMinuto(120);

        PraiaBrava praiaBrava2 = new PraiaBrava();
        praiaBrava2.setNome("Praia do Japao");
        praiaBrava2.setExtensao(400);
        praiaBrava2.setQuantidadeDeOndasPorMinuto(50);
//        populando a lista
        praias.add(praiaCalma1);
        praias.add(praiaCalma2);
        praias.add(praiaBrava1);
        praias.add(praiaBrava2);

        //nomeExtensao(praias);
        tudoDasPraias(praias);
    }
    public static void nomeExtensao(List<Praia> p){
        for(int i = 0; i < p.size(); i++){
            String nome = p.get(i).getNome();
            int ext = p.get(i).getExtensao();
            System.out.println("******\n"+nome+"\n"+ext+" metros");
        }
    }

    public static void tudoDasPraias(List<?> prs){
        for(Object p: prs){
            System.out.println(p.toString()+"\n***************************");
        }
//    quando uso a Generics devo buscar o método que existir nas classes, do outro jeito uso os métodos nativos do Tipo
    }


}
