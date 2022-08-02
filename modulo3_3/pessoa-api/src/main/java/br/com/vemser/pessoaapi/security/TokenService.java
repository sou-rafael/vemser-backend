package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UsuarioService usuarioService;

    private static final String TOKEN_PREFIX = "Bearer ";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String getToken(UsuarioEntity usuarioEntity) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.valueOf(expiration)); // tempo de expiração = agora + 1 dia em milisegundos

        String token = Jwts.builder()
                .setIssuer("pessoa-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario()) // usar o valor direto (Integer), não colocar o toString()
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return TOKEN_PREFIX + token;

    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token == null) {
            return null;
        }
        Claims payload = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)  //pq o Bearer ja esta sendo removido em TokenAuthenticationFilter
                .getBody();

        Integer idUsuario = payload.get(Claims.ID, Integer.class);
        if (idUsuario != null) {

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(idUsuario, null, Collections.emptyList());  // busca usuario do jwt e seta para usernamePass...

            return usernamePasswordAuthenticationToken;
        }
        return null;
    }
}
