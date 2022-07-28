package br.com.vemser.pessoaapi.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {
    @NotNull
    private String login;
    @NotNull
    private String senha;
}
