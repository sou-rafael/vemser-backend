import java.util.Scanner;

public class q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int anos, meses, dias, idade;
        System.out.println("Digite a idade em ANOS, MESES e DIAS");

        System.out.println("Anos:");
        anos = sc.nextInt();
        sc.nextLine();

        System.out.println("Meses:");
        meses = sc.nextInt();
        sc.nextLine();

        System.out.println("Dias:");
        dias = sc.nextInt();
        sc.nextLine();

        if (meses>=1 && meses<=12 && dias>=0 && dias<=30){
            idade = (anos * 365) + (meses * 30) + dias;
            System.out.println("A idade em dias eh: " + idade + " dias.");
        }
        else{
            System.out.println("Os valores inseridos nao estao corretos, verifique por favor.");
        }

    }
}