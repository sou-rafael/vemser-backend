import java.util.Scanner;
public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite a idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite a cidade: ");
        String cidade = sc.nextLine();

        System.out.println("Digite o estado: ");
        String estado = sc.nextLine();

        System.out.println("Ola seu nome eh "+nome+", voce tem "+idade+", eh da cidade de "+cidade+", situada no estado do "+estado);
    }
}
