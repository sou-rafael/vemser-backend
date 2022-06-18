import java.util.Scanner;
public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Valor total consumido: ");
        double consumo = sc.nextDouble();
        sc.nextLine();
        System.out.println("Valor pago pelo cliente: ");
        double pago = sc.nextDouble();
        sc.nextLine();

        if(consumo>pago){
            double dif = consumo - pago;
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido.");
            System.out.println("Falta: "+dif+" reais.");
        } else {
            double troco = pago - consumo;
            System.out.println("O troco eh de: "+troco+" reais.");
        }

    }
}
