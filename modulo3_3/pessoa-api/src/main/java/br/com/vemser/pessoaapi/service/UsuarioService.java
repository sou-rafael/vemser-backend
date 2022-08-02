package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import br.com.vemser.pessoaapi.security.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    public String cadastrar(LoginDTO loginDTO) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        loginDTO.setSenha(bCryptPasswordEncoder.encode(loginDTO.getSenha()));

        UsuarioEntity usuarioEntity = objectMapper.convertValue(loginDTO, UsuarioEntity.class);

        usuarioRepository.save(usuarioEntity);

        return "Usuario cadastrado com sucesso!" +
                "\nid = " + usuarioEntity.getIdUsuario() +
                "\nlogin = " + loginDTO.getLogin();

    }

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }


    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserId;
    }

    public UsuarioEntity getLoggedUser() throws RegraDeNegocioException {
        return findById(getIdLoggedUser());
    }

    public UsuarioEntity findById(Integer idUsuario) throws RegraDeNegocioException {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow((() -> new RegraDeNegocioException("Usuario nao encontrado")));
    }
}
