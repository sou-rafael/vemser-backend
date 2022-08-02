public class ContaPoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public ContaPoupanca() {

    }

    public void creditarTaxa() {
        this.setSaldo(super.getSaldo() * this.JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println("Dados da ContaPoupanca");
        System.out.println("Cliente: ");
        this.getCliente().imprimirCliente();
        System.out.println("Numero da conta: " + this.getNumeroConta());
        System.out.println("Agencia: " + this.getAgencia());
        System.out.println("Saldo: " + this.getSaldo());
    }
}