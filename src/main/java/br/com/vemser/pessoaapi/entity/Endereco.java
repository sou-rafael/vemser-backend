package br.com.vemser.pessoaapi.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
//    @NotNull
    private TipoEndereco tipo;
//    @NotEmpty
//    @Size(min = 1, max = 250, message = "Verifique o tamanho de no maximo 250")
    private String logradouro;
//    @NotNull
    private Integer numero;
    private String complemento;
//    @NotEmpty
//    @Size(min = 8, max = 9)
    private String cep;
//    @NotEmpty
//    @Size(min = 1, max = 250)
    private String cidade;
//    @NotBlank
    private String estado;
    // @Getter(AccessLevel.none)
//    @NotBlank
    private String pais;
}

