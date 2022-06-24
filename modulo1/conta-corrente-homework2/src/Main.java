public class Main {
    public static void main(String[] args) {
        //CLIENTE 1
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Rafael");
        cliente1.setCpf("111.222.333-90");

        //inserindo contatos
        Contato cont1 = new Contato("pessoal", "86 91111-1111",1);
        Contato cont2 = new Contato("horario comercial", "86 92222-2222", 2);
        Contato[] contatoc1 = new Contato[] {cont1, cont2};
        cliente1.setContatos(contatoc1);

        //Contato ex1 = newgetContato()[0]; ??

        // inserindo enderecos
        Endereco end1c1 = new Endereco(1, "rua 12", 3, "sem compl",
                "64000-000","Teresina", "Piaui", "Brasil");
        Endereco end2c1 = new Endereco(2, "rua clara", 345, "sem compl",
                "64034-000","Parnaiba", "Piaui", "Brasil");
        Endereco[] endereco = new Endereco[] {end1c1,end2c1};
        cliente1.setEnderecos(endereco);

        //CLIENTE 2
        Cliente cliente2 = new Cliente();
        cliente1.setNome("Bianca");
        cliente1.setCpf("444.555.666.-80");

        //inserindo contatos
        Contato cont1c2 = new Contato("pessoal", "99 98576-4857",1);
        Contato cont2c2 = new Contato("horario comercial", "98 93456-6789", 2);
        Contato[] contatoc2 = new Contato[] {cont1c2, cont2c2};
        cliente1.setContatos(contatoc2);

        // inserindo enderecos
        Endereco end1c2 = new Endereco(1, "rua alta", 2578, "sem compl",
                "65069-796","Buriti", "Ceara", "Brasil");
        Endereco end2c2 = new Endereco(2, "rua sem jeito", 4358, "sem compl",
                "64034-000","Floriano", "Piaui", "Brasil");
        Endereco[] enderecoc2 = new Endereco[] {end1c2,end2c2};
        cliente1.setEnderecos(enderecoc2);
//     ************************************************
        //conta corrente
        ContaCorrente contaC1 = new ContaCorrente();
        contaC1.setCliente(cliente1);
        contaC1.setNumeroConta("3333");
        contaC1.setAgencia("1111");
        contaC1.setSaldo(3000.00);
        contaC1.setChequeEspecial(500.00);

        ContaCorrente contaC2 = new ContaCorrente();
        contaC2.setCliente(cliente2);
        contaC2.setNumeroConta("4444");
        contaC2.setAgencia("2222");
        contaC2.setSaldo(6000.00);
        contaC2.setChequeEspecial(800.00);

        //conta poupanca
        ContaPoupanca contaP1 = new ContaPoupanca();
        contaP1.setCliente(cliente1);
        contaP1.setNumeroConta("4444");
        contaP1.setAgencia("2222");
        contaP1.setSaldo(6000);

        ContaPoupanca contaP2 = new ContaPoupanca();
        contaP2.setCliente(cliente2);
        contaP2.setNumeroConta("4444");
        contaP2.setAgencia("2222");
        contaP2.setSaldo(6000);

        //--------------------------------------------
//OPERAÇÕES EM CONTA CORRENTE
        //saque conta corrente
        System.out.println("OP de Saque");
        System.out.println("Saldo inicial contaC1 = "+contaC1.getSaldo());
        contaC1.sacar(1500);
        System.out.println("Saldo dps do saque de 1500 na contaC1 = "+contaC1.getSaldo());
        System.out.println("---------------");
        System.out.println("Saldo inicial contaC2 = "+contaC2.getSaldo());
        contaC2.sacar(2600);
        System.out.println("Saldo inicial contaC2 = "+contaC2.getSaldo());
        System.out.println("---------------");

        //depositar em conta corrente
        System.out.println("OP de Deposito");
        System.out.println("Saldo inicial contaC2 = "+contaC1.getSaldo());
        contaC1.depositar(100);
        System.out.println("Saldo dps do deposito de 100 contaC1 = "+contaC1.getSaldo());

        System.out.println("---------------");
        System.out.println("Saldo inicial contaC2 = "+contaC2.getSaldo());
        contaC2.depositar(500);
        System.out.println("Saldo dps do deposito de 500 contaC2 = "+contaC2.getSaldo());
        System.out.println("---------------");



        //saldo total
        System.out.println("Saldo acrescido de cheque especial");
        System.out.println("O saldoCC com cheque especial de contaC1 eh: " + contaC1.retornarSaldoComChequeEspecial());
        System.out.println("O saldoCC com cheque especial de contaC2 eh: " + contaC2.retornarSaldoComChequeEspecial());
        System.out.println("---------------");
//
        //transferir valor entre contas

        System.out.println("Transferencia de 700 entre contaC1 e contaC2 ");
        System.out.println("Saldo atual contaC1 = "+contaC1.getSaldo());
        System.out.println("Saldo atual contaC2 = "+contaC1.getSaldo());
        System.out.println("---------------");

        //creditar taxa da conta poupanca
        contaP2.creditarTaxa();
        contaP2.imprimir();
        System.out.println("---------------");

        //imprimir os dados da conta corrente
        contaC1.imprimir();
        contaC2.imprimir();



    }
}