import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome = "";
        double altura, somaAltura = 0, mediaAltura = 0, idade, maiorIdade = 0, peso, maiorPeso = 0;
        while(!nome.equalsIgnoreCase("SAIR")){
            System.out.println("Nome:");
            nome = sc.nextLine();

            System.out.println("Insira a altura:");
            altura = sc.nextDouble();
            somaAltura = somaAltura + altura;


        }
    }
}