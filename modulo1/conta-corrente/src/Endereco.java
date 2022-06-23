public class Endereco {
    int tipo = 0; // 1-residencial , 2-comercial
    int numero;
    String logradouro, complemento, cep, cidade, estado, pais;

    public void imprimirEndereco(){
        System.out.println("Logradouro: "+logradouro);
        System.out.println("Numero: "+numero);
        System.out.println("Complemento: "+complemento);
        System.out.println("Tipo: "+tipo);
        System.out.println("CEP: "+cep);
        System.out.println("Cidade: "+cidade+", Estado: "+estado+", Pais: "+pais);

    }
    @Override
    public String toString() {
        return "Endereco{" +
                "tipo=" + tipo +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
