package br.com.vemser.pessoaapi.criadordesenha;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriadorDeSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        System.out.println(senha);
        // $2a$10$hFVjgQER7DkakTHpGLimdu.7uam7Coa0xOenT77Xx5nkMs4bKYA9C
        // $2a$10$HnGGTMoLucvM7LeQKw9wSOtWelUKIqM9OVZXzWYjb4IrJE4F.2TWO
//        =============================================

        String senhaCript = "$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO";
        boolean matches = bCryptPasswordEncoder.matches("123", senhaCript);
        System.out.println(matches);
    }
}
