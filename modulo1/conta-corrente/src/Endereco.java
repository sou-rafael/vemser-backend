public class Endereco {
    int tipo = 0; // 1-residencial , 2-comercial
    int numero = 0;
    String logradouro="";
    String complemento="";
    String cep="";
    String cidade="";
    String estado="";
    String pais="";

    public void imprimirEndereco(){
        System.out.println("Logradouro: "+logradouro);
        System.out.println("Numero: "+numero);
        System.out.println("Complemento: "+complemento);
        System.out.println("Tipo: "+tipo);
        System.out.println("CEP: "+cep);
        System.out.println("Cidade: "+cidade+", Estado: "+estado+", Pais: "+pais);

    }

}
