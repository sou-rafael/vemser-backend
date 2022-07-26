package br.com.vemser.pessoaapi.documentations;

import br.com.vemser.pessoaapi.annotations.Notas;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

public interface PessoaDocs {
    @Notas
    @Operation(summary = "Listar pessoa", description = "Lista todas as pessoas")
    public List<PessoaDTO> list() throws RegraDeNegocioException;
    @Notas
    @Operation(summary = "Listar pessoas por nome", description = "Lista pessoas por nome ou trechos de nome")
    public List<PessoaDTO> listByName(@RequestParam("nome")String nome) throws RegraDeNegocioException;
    @Notas
    @Operation(summary = "Atualizar dados da pessoa e envia um email de confirmação", description = "Atualiza todos os dados da pessoa e envia um email de confirmação")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id, @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException;
    @Notas
    @Operation(summary = "Cria uma nova pessoa e envia um email de confirmação", description = "Insere uma nova pessoa e envia um email de confirmação")
    public PessoaDTO create(@RequestBody PessoaCreateDTO pessoa) throws RegraDeNegocioException;
    @Notas
    @Operation(summary = "Apagar uma pessoa e envia um email de confirmação", description = "Apaga uma pessoa especificada por id e envia um email de confirmação")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException;



}
