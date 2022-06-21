import java.util.Scanner;
public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lista = new int[3];

//        Criar a lista de valores
        for(int i = 0; i<= lista.length-1; i++){
            System.out.println("Insira um numero na posicao "+i);
            lista[i] = sc.nextInt();
            sc.nextLine();
        }

//        Fazer a busca pelo maior e capturar seu indice
        int menor = lista[0];
        int indiceMenor = -1;

        for(int i = 0; i < lista.length; i++){
            if(lista[i] < menor){
                menor = lista[i];
                indiceMenor = i;
            }
        }
        System.out.println("A posicao do menor numero eh: "+indiceMenor+"\nE seu valor eh: "+menor);

    }
}
