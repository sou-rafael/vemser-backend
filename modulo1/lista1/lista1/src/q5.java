import java.util.Scanner;
public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Valor da hora:");
        double a = sc.nextDouble();
        sc.nextLine();

        System.out.println("Numero de horas trabalhadas:");
        double b = sc.nextDouble();
        sc.nextLine();

        System.out.println("Numero de horas extras 50%:");
        double c = sc.nextDouble();
        sc.nextLine();

        System.out.println("Numero de horas extras 100%:");
        double d = sc.nextDouble();
        sc.nextLine();

        double salarioBruto = (b*a)+(c*a*1.5)+(d*a*2);

        System.out.println("O salario bruto eh: R$ "+salarioBruto);

    }
}
