public class ContaPoupanca extends Conta implements Impressao{
    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo){
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa(){
        super.setSaldo(getSaldo() * this.JUROS_MENSAL);
    }

@Override
public void imprimir() {
        System.out.println("Dados da ContaPoupanca");
        System.out.println("Cliente: ");
        getCliente().imprimirCliente();
        System.out.println("Numero da conta: "+getNumeroConta());
        System.out.println("Agencia: "+getAgencia());
        System.out.println("Saldo: "+getSaldo());
    }
}