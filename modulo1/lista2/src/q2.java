import java.util.Scanner;
import java.util.Random;
public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numAlvo, numTenta;
        Random gerador = new Random();

        numAlvo = gerador.nextInt(10);

        do {
            System.out.println("Advinhe qual eh o numero que eu pensei.");
            numTenta = sc.nextInt();
            sc.nextLine();
            if(numAlvo < numTenta){
                System.out.println("O numero a ser encontrado eh MENOR do que o que voce digitou.");
            }
            else if(numAlvo > numTenta){
                System.out.println("O numero a ser encontrado eh MAIOR do que o que voce digitou.");
            }else{
                System.out.println("Parabens! Acertou");
            }
        }while(numAlvo != numTenta);
        sc.close();
    }
}

//a[i] = (int)Math.round(Math.random() * 10); // gera um número inteiro aleatório no intervalo de 0 até 10