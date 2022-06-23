public class ContaPoupanca extends Conta{
    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo){
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa(){
        super.setSaldo(getSaldo() * this.JUROS_MENSAL);
    }
}
