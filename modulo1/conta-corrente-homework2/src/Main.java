public class Main {
    public static void main(String[] args) {
        //criar os clientes usando construtor
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Rafael");
        cliente1.setCpf("111.222.333-90");
        cliente1.setContatos("6547474");
//*****************************************************
        //Contato
        Contato contato1 = new Contato();
        contato1.tipo = 1;
        contato1.telefone = "55998753421";
        contato1.descricao = "Celular";
        Contato contato2 = new Contato();
        contato2.tipo = 2;
        contato2.telefone = "55456753400";
        contato2.descricao = "Telefone";

        System.out.println("CONTATO:");
        contato1.imprimirContato();
        System.out.println("----------------------------------");
        contato2.imprimirContato();
        System.out.println("----------------------------------");

        //Endereço
        Endereco endereco1 = new Endereco();
        endereco1.estado = "AM";
        endereco1.cep = "69093840";
        endereco1.cidade = "Manaus";
        endereco1.complemento = "n/a";
        endereco1.numero = 970;
        endereco1.logradouro = "Rua São Valentin";
        endereco1.tipo = 1;
        endereco1.pais = "Brasil";
        Endereco endereco2 = new Endereco();
        endereco2.estado = "SP";
        endereco2.cep = "05866040";
        endereco2.cidade = "São Paulo";
        endereco2.complemento = "n/a";
        endereco2.numero = 412;
        endereco2.logradouro = "Rua Henri Matisse";
        endereco2.tipo = 2;
        endereco2.pais = "Brasil";

        System.out.println("ENDEREÇO:");
        endereco1.imprimirEndereco();
        System.out.println("----------------------------------");
        endereco2.imprimirEndereco();
        System.out.println("----------------------------------");

        //Cliente
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();

        cliente1.nome = "Levi Otávio dos Santos";
        cliente1.cpf = "14576283928";
        cliente1.contatos[0]= contato1;
        cliente1.enderecos[0]= endereco1;
        System.out.println("CLIENTE:");
        cliente1.imprimirCliente();

        cliente2.nome = "Giovana Valentina";
        cliente2.cpf = "42389174566";
        cliente2.contatos[0] = contato1;
        cliente2.enderecos[0] = endereco1;
        cliente2.contatos[1] = contato2;
        cliente2.enderecos[1] = endereco2;
        cliente2.imprimirCliente();
        System.out.println("----------------------------------");
        cliente2.imprimirContatos();
        System.out.println("----------------------------------");
        cliente2.imprimirEnderecos();
        System.out.println("----------------------------------");

        //ContaCorrente
        ContaCorrente cc1 = new ContaCorrente();
        cc1.cliente = cliente1;
        cc1.numeroConta = "1000";
        cc1.agencia = 1;
        cc1.saldo = 0;
        ContaCorrente cc2 = new ContaCorrente();
        cc2.cliente = cliente2;
        cc2.numeroConta = "1000";
        cc2.agencia = 2;
        cc2.saldo = 0;

        cc1.depositar(100);
        cc1.sacar(10);
        cc1.transferir(cc2,50);
        System.out.println("CONTA CORRENTE:");
        cc1.imprimirContaCorrente();
        System.out.println("----------------------------------");
        cc2.imprimirContaCorrente();

    }
}

    }
}