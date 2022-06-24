import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //CLIENTE 1
                    //inserindo contatos
        Contato cont1 = new Contato("pessoal", "86 91111-1111",1);
        Contato cont2 = new Contato("horario comercial", "86 92222-2222", 2);
        ArrayList<Contato> contatoc1 = new ArrayList<>();
        contatoc1.add(cont1);
        contatoc1.add(cont2);

                                //Contato ex1 = newgetContato()[0]; ??

                    // inserindo enderecos
        Endereco end1c1 = new Endereco(1, "rua 12", 3, "sem compl",
                "64000-000","Teresina", "Piaui", "Brasil");
        Endereco end2c1 = new Endereco(2, "rua clara", 345, "sem compl",
                "64034-000","Parnaiba", "Piaui", "Brasil");
        ArrayList<Endereco> endereco = new ArrayList<>();
        endereco.add(end1c1);
        endereco.add(end2c1);

        Cliente cliente1 = new Cliente("Rafael", "444.444.444-90", contatoc1, endereco);

        //CLIENTE 2
                    //inserindo contatos
        Contato cont1c2 = new Contato("pessoal", "99 98576-4857",1);
        Contato cont2c2 = new Contato("horario comercial", "98 93456-6789", 2);
        ArrayList<Contato> contatoc2 = new ArrayList<>();
        contatoc2.add(cont1c2);
        contatoc2.add(cont2c2);

                    // inserindo enderecos
        Endereco end1c2 = new Endereco(1, "rua alta", 2578, "sem compl",
                "65069-796","Buriti", "Ceara", "Brasil");
        Endereco end2c2 = new Endereco(2, "rua sem jeito", 4358, "sem compl",
                "64034-000","Floriano", "Piaui", "Brasil");
        ArrayList<Endereco> enderecoc2 = new ArrayList<>();
        enderecoc2.add(end1c2);
        enderecoc2.add(end2c2);

        Cliente cliente2 = new Cliente("Bianca", "777.777.777-88", contatoc2, enderecoc2);

        //     ************************************************

        // CLIENTE1 conta corrente e conta pagamento
        ContaCorrente contaCorr1 = new ContaCorrente(cliente1, "3333-3", "1111", 3000, 500);

        ContaPagamento contaPagC1 = new ContaPagamento(cliente1, 2000);

        //CLIENTE2 conta poupanca
        ContaPoupanca contaPoup2 = new ContaPoupanca(cliente2, "2222-2", "43", 5000);

        //--------------------------------------------


//MOVIMENTAÇÕES
        //SAQUE
        System.out.println("---********-----SAQUE-----************---");

        System.out.println("Saque\nConta Corrente CLIENTE1");
        System.out.println("Saldo inicial= "+contaCorr1.getSaldo()+"\nSacar R$ 1500");
        contaCorr1.sacar(1500);
        System.out.println("Saldo dps do saque= "+contaCorr1.getSaldo());

        System.out.println("---------------");

        System.out.println("Saque\nConta Pagamento CLIENTE1");
        System.out.println("Saldo inicial= "+contaPagC1.getSaldo());
        contaPagC1.sacar(1900);
        System.out.println("Saldo apos o saque de R$ 1900 (+taxa de saque)= "+contaPagC1.getSaldo());
        System.out.println("---------------");

        System.out.println("Saque\nConta Poupanca CLIENTE2");
        System.out.println("Saldo inicial= "+contaPoup2.getSaldo());
        contaPoup2.sacar(2000);
        System.out.println("Saldo apos o saque de R$ 2000= "+contaPagC1.getSaldo());
        System.out.println("---------------");

        //DEPÓSITO
        System.out.println("---********-----DEPOSITO-----************---");

        System.out.println("Deposito \nConta Corrente CLIENTE1");
        System.out.println("Saldo inicial= "+contaCorr1.getSaldo());
        contaCorr1.depositar(1000);
        System.out.println("Saldo dps do deposito de R$ 1000= "+contaCorr1.getSaldo());
        System.out.println("---------------");

        System.out.println("Deposito \nConta Pagamento CLIENTE1");
        System.out.println("Saldo inicial= "+contaPagC1.getSaldo());
        contaPagC1.depositar(500);
        System.out.println("Saldo apos o deposito de R$ 500= "+contaPagC1.getSaldo());
        System.out.println("---------------");

        System.out.println("Deposito \nConta Poupanca CLIENTE2");
        System.out.println("Saldo inicial= "+contaPoup2.getSaldo());
        contaPoup2.depositar(500);
        System.out.println("Saldo apos o deposito de R$ 500= "+contaPoup2.getSaldo());
        System.out.println("---------------");

        //TRANSFERENCIAS
        System.out.println("---********-----TRANSFERENCIAS-----************---");
        // corrente (contaCorr1) --> pagamento (contaPagC1)
        System.out.println("Saldo inicial" +
                "\nC.Corrente cliente1 = R$ "+contaCorr1.getSaldo()+
                "\nC.Pagamento cliente1 = R$ "+contaPagC1.getSaldo());
        contaCorr1.transferir(contaPagC1, 1000);
        System.out.println("\nSaldo apos transferencia de R$ 1000" +
                "\nC.Corrente cliente1 = R$ "+contaCorr1.getSaldo()+
                "\nC.Pagamento cliente1 = R$ "+contaPagC1.getSaldo());
        System.out.println("---------------");

        // corrente (contaCorr1) --> poupanca (contaPoup2)
        System.out.println("Saldo inicial" +
                "\nC.Corrente cliente1 = R$ "+contaCorr1.getSaldo()+
                "\nC.Poupanca cliente2 = R$ "+contaPoup2.getSaldo());
        contaCorr1.transferir(contaPoup2, 1000);
        System.out.println("\nSaldo apos transferencia de R$ 1000" +
                "\nC.Corrente cliente1 = R$ "+contaCorr1.getSaldo()+
                "\nC.Poupanca cliente2 = R$ "+contaPoup2.getSaldo());
        System.out.println("---------------");

        // pagamento (contaPagC1) --> poupança (contaPoup2)
        System.out.println("Saldo inicial" +
                "\nC.Pagamento cliente1 = R$ "+contaPagC1.getSaldo()+
                "\nC.Poupanca cliente2 = R$ "+contaPoup2.getSaldo());
        contaPagC1.transferir(contaPoup2, 1000);
        System.out.println("\nSaldo apos transferencia de R$ 1000" +
                "\nC.Pagamento cliente1 = R$ "+contaPagC1.getSaldo()+
                "\nC.Poupanca cliente1 = R$ "+contaPoup2.getSaldo());
        System.out.println("---------------");

        // pagamento (contaPagC1) --> corrente (contaCorr1)
        System.out.println("Saldo inicial" +
                "\nC.Pagamento cliente1 = R$ "+contaPagC1.getSaldo()+
                "\nC.Corrente cliente1 = R$ "+contaCorr1.getSaldo());
        contaPagC1.transferir(contaCorr1, 1000);
        System.out.println("\nSaldo apos transferencia de R$ 1000" +
                "\nC.Pagamento cliente1 = R$ "+contaPagC1.getSaldo()+
                "\nC.Corrente cliente1 = R$ "+contaCorr1.getSaldo());
        System.out.println("---------------");

        // poupanca (contaPoup2) --> pagamento (contaPagC1)
        System.out.println("Saldo inicial" +
                "\nC.Poupanca cliente2 = R$ "+contaPoup2.getSaldo()+
                "\nC.Pagamento cliente1 = R$ "+contaPagC1.getSaldo());
        contaPoup2.transferir(contaPagC1, 1000);
        System.out.println("\nSaldo apos transferencia de R$ 1000" +
                "\nC.Poupanca cliente2 = R$ "+contaPoup2.getSaldo()+
                "\nC.Pagamento cliente1 = R$ "+contaPagC1.getSaldo());
        System.out.println("---------------");

        // poupanca (contaPoup2) --> corrente (contaCorr1)
        System.out.println("Saldo inicial" +
                "\nC.Poupanca cliente2 = R$ "+contaPoup2.getSaldo()+
                "\nC.Corrente cliente1 = R$ "+contaCorr1.getSaldo());
        contaPoup2.transferir(contaCorr1, 1000);
        System.out.println("\nSaldo apos transferencia de R$ 1000" +
                "\nC.Poupanca cliente2 = R$ "+contaPoup2.getSaldo()+
                "\nC.Corrente cliente1 = R$ "+contaCorr1.getSaldo());
        System.out.println("---------------");



        //imprimir os dados das contas
        contaCorr1.imprimir();
        contaPagC1.imprimir();
        contaPoup2.imprimir();



    }
}