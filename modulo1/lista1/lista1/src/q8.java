import java.util.Scanner;

public class q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base, altura, area;
        System.out.println("-Area do Retangulo-"+"\nDigite o Valor da base"+"\nem seguida o Valor da altura");

        base = sc.nextDouble();
        sc.nextLine();
        altura = sc.nextDouble();
        sc.nextLine();

        area = base*altura;
        System.out.println("Area = "+area);
    }
}
