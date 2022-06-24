public class ContaPagamento extends Conta implements Impressao {
    static final Double TAXA_SAQUE = 4.25;

    @Override
    public void imprimir() {
        System.out.println("Cliente: " + getCliente().getNome());
        getCliente().imprimirCliente();
        System.out.println("Numero da conta: " + getNumeroConta());
        System.out.println("Agencia: " + getAgencia());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Taxa de saque: " + TAXA_SAQUE);
    }

    // TRANSFERIR PRECISA SER SOBRESCRITO DEVIDO À TAXA_SAQUE, QUE ALTERA O METODO SAQUE
    @Override
    public boolean transferir(Conta conta, double valor) {
        if(this.getSaldo()>valor && valor>0){
            this.sacar(valor);
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() > valor && valor > 0) {
            if (this.getSaldo() - valor - TAXA_SAQUE > 0) {
                this.setSaldo(getSaldo() - valor - TAXA_SAQUE);
                return true;
            }else return false;
        } else return false;
    }
    // contrutor
    public ContaPagamento(Cliente cliente, double saldo){
        super.setCliente(cliente);
        super.setSaldo(saldo);
    }
}

