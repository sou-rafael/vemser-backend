public class q7 {
    public static void main(String[] args) {
        int a = 10, b = 20, c;
        System.out.println("Valores iniciais:"+"\na = "+a+"\nb = "+b);

        c = a;
        a = b;
        b = c;
        System.out.println("Valores trocados:"+"\na = "+a+"\nb = "+b);

    }
}
