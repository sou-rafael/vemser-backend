import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------DIVISAO-----------");
        boolean erro = false;
        int n1 = 0;
        int n2 = 0;

        while(!erro){
            try {
                System.out.print("Digite o 1o numero: ");
                n1 = sc.nextInt();
                sc.nextLine();

                System.out.print("Digite o 2o numero: ");
                n2 = sc.nextInt();
                sc.nextLine();

                erro = true;
            }catch (ArithmeticException e){
                e.printStackTrace();
                System.out.println("Digite um numero, por favor.");
            }finally {
                double resultado = 0;
                try {
                    resultado = n1 / n2;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Voce nao informou valores numericos.\nRepita a operacao.");
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                    System.out.println("Nao eh possivel dividir nenhum numero por zero, tente novamente.");
                } finally {
                    System.out.println(resultado);
                    sc.close();
                }
            }
        }
    }
}
