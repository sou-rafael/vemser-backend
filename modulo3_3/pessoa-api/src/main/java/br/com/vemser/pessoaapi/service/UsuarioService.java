package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public LoginDTO cadastrar(LoginDTO loginDTO) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        loginDTO.setSenha(bCryptPasswordEncoder.encode(loginDTO.getSenha())); // cria senha cripto e seta

        UsuarioEntity usuarioEntity = objectMapper.convertValue(loginDTO, UsuarioEntity.class);

        return objectMapper.convertValue(usuarioRepository.save(usuarioEntity), LoginDTO.class);
    }
    // obs NAO RETORNAR A SENHA DE VOLTA NO ENDPOINT - pode-se criar um dto que retorne id e usuario, mas sem a senha

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

//    public Optional<UsuarioEntity> findById(Integer idUsuario) {
//        return usuarioRepository.findById(idUsuario);
//    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public Integer getIdLoggedUser(){
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserId;
    }

    public UsuarioEntity getLoggedUser() throws RegraDeNegocioException{
        return findById(getIdLoggedUser());
    }

    public UsuarioEntity findById(Integer idUsuario) throws RegraDeNegocioException{
        return usuarioRepository.findById(idUsuario)
                .orElseThrow((() -> new RegraDeNegocioException("Usuario nao encontrado")));
    }
}
