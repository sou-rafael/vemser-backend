package br.com.vemser.pessoaapi;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class PessoaApiApplicationTests {

	@Test
	void contextLoads() {

		PessoaService pessoaService = new PessoaService();
		PessoaRepository pessoaRepository = new PessoaRepository();
		ObjectMapper objectMapper = new ObjectMapper();

		PessoaCreateDTO pessoaDTO = new PessoaCreateDTO();
		pessoaDTO.setCpf("41255446677");
		pessoaDTO.setNome("Paulo");
		pessoaDTO.setDataNascimento(LocalDate.parse("2012-12-09"));

		Pessoa pessoaEntity = objectMapper.convertValue(pessoaDTO, Pessoa.class); //o objectMapperconverte
		Pessoa p = pessoaRepository.create(pessoaEntity);
		System.out.println(pessoaDTO);
		System.out.println(pessoaEntity);
		System.out.println(p);
	}

}
