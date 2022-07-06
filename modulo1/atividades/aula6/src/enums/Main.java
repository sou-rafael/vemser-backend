package enums;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pedido[] values = Pedido.values();
        for (Pedido pedido: values) {
            System.out.println(pedido.getDescricao());
        }
    }
}
