package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Rafael");
        nomes.add("Bianca");
        nomes.add("Alice peixoto ferreira");


        System.out.println("Digite outros nomes e quando terminar digite sair:");
        String digite = sc.nextLine();
        while(!digite.equalsIgnoreCase("sair")){
            nomes.add(digite);
            System.out.println("Digite outros nomes e quando terminar digite sair:");
            digite = sc.nextLine();
        }

        System.out.println("esta eh a lista inicial: "+ nomes.toString());
        System.out.println("Penultimo nome da lista: "+ nomes.get(nomes.size()-2));
        System.out.println("Primeiro nome da lista: "+ nomes.get(0));
        System.out.println("Removendo '"+nomes.remove(nomes.size()-1)+"' que era o ultimo nome da lista");
        System.out.println("Lista atual: "+nomes);

    }
}
