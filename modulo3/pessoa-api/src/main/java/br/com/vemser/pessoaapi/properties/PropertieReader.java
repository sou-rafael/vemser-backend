package br.com.vemser.pessoaapi.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertieReader {
    public String getAmbiente() {
        return ambiente;
    }

    @Value("${ambiente}")
    private String ambiente;

    @Value("${spring.mail.username}")
    private String email;

    public String getEmail() {
        return email;
    }
}
