import java.util.Scanner;
public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a 1a nota: ");
        double nota1 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a 2a nota: ");
        double nota2 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a 3a nota: ");
        double nota3 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a 4a nota: ");
        double nota4 = sc.nextDouble();
        sc.nextLine();

        double media = (nota1+nota2+nota3+nota4)/4;

        if(media >= 0 && media <= 5){
            System.out.println("Esta reprovado, com media: "+media);
        } else if (media >= 5.1 && media <= 6.9) {
            System.out.println("Esta em exame, com media: "+media);
        }else {
            System.out.println("Esta aprovado, com media: "+media);
        }

    }
}
