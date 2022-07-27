package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
private final UsuarioService usuarioService;
    public String getToken(UsuarioEntity usuarioEntity) {
        // FIXME por meio do usuário, gerar um token
        String tokenTexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes());
        return token;
    }

    public Optional<UsuarioEntity> isValid(String token) {
        // FIXME validar se o token é válido e retornar o usuário se for válido
        if(token == null){
            return Optional.empty();
        }
        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decodedBytes);
        String[] split = decoded.split(";");
        Optional<UsuarioEntity> optionalUsuario = usuarioService.findByLoginAndSenha(split[0], split[1]);
        return optionalUsuario;
    }
}
