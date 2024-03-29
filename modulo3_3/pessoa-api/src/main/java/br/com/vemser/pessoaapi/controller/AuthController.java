package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.security.TokenService;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha()
                );
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        Object usuarioLogado = authentication.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioLogado;
        String token = tokenService.getToken(usuarioEntity);
        return token;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody LoginDTO loginDTO) {
        return usuarioService.cadastrar(loginDTO);
    }

    @GetMapping("/recuperarLogin")
    public String usuarioLogado() throws RegraDeNegocioException {
        Integer idLoggedUser = usuarioService.getIdLoggedUser();
        UsuarioEntity usuarioLogadoEntity = usuarioService.findById(idLoggedUser);
        return usuarioLogadoEntity.getLogin();
    }
}