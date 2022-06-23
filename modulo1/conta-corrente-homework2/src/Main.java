public class Main {
    public static void main(String[] args) {
        //criar os clientes usando construtor
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Rafael");
        cliente1.setCpf("111.222.333-90");

        //inserindo contatos
        Contato cont1 = new Contato("pessoal", "86 91111-1111",1);
        Contato cont2 = new Contato("horario comercial", "86 92222-2222", 2);
        Contato[] contato = new Contato[] {cont1, cont2};
        cliente1.setContatos(contato);





    }
}