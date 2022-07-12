package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Slf4j
@Repository
public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi", "10/10/1990", "12345678910", "primeiro@fasfa.com.br"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", "08/05/1985", "12345678911","segundo@email.com.br"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira","30/03/1970", "12345678912","terceiro@email.com.br"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*4*/, "Rafael Lazzari","01/07/1990", "12345678916","quarto@email.com.br"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*5*/, "Ana","01/07/1990", "12345678917","quinto@email.com.br"));
    }

    public List<Pessoa> listar() {
        return listaPessoas;
    }
    public Pessoa create(Pessoa pessoa) {
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }

    public void delete(Integer id){
        Pessoa pessoaApagar = listar().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst().get();

        listaPessoas.remove(pessoaApagar);
    }
    public void update(Integer id, Pessoa pessoaAtualizar) throws RegraDeNegocioException {
        listaPessoas.add(id-1, pessoaAtualizar);
        log.info("Na repository, pessoa atualizada");
    }
/*
    //GET POR NOME
    public List<Pessoa> listByName(String nome) {
        return null;
    }*/
}
