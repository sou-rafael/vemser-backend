package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import br.com.vemser.pessoaapi.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioEntity> usuarioOptional = usuarioService.findByLogin(username);

        return usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuario invalido"));
    }

    public LoginDTO cadastrar(LoginDTO loginDTO) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        loginDTO.setSenha(bCryptPasswordEncoder.encode(loginDTO.getSenha())); // cria senha cripto e seta

        UsuarioEntity usuarioEntity = objectMapper.convertValue(loginDTO, UsuarioEntity.class);

        return objectMapper.convertValue(usuarioRepository.save(usuarioEntity), LoginDTO.class);
    }
}
