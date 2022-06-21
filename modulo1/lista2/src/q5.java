import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] lista = new double[20]; // corrigir o valor para 20

        for(int i = 0; i < 20; i++){
            System.out.println("Insira o numero da posicao "+i);
            lista[i] = sc.nextDouble();
            sc.nextLine();
        }

        System.out.println("na ordem inversa:");
        for(int i = lista.length-1 ; i>=0 ; i--){
            System.out.println(lista[i]);
        }
    }
}
