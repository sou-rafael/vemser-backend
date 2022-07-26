package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet") // localhost:8080/pessoa
@Validated
@RequiredArgsConstructor
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    public List<PetDTO> list()throws RegraDeNegocioException{
        return petService.list();
    }
    @PostMapping("/{idPessoa}")
    public PetDTO create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody PetCreateDTO petCreateDTO)throws RegraDeNegocioException{
        return petService.create(idPessoa, petCreateDTO);
    }

    //TODO - verificar a questao de fazer trocar o pet de dono (apagando a ligação com o antigo para poder fazer a com novo)
    @PutMapping("/{idPet}")
    public PetDTO update(@PathVariable("idPet") Integer idPessoa, @RequestBody PetCreateDTO petCreateDTO) throws RegraDeNegocioException{
        return petService.update(idPessoa, petCreateDTO);
    }

    @DeleteMapping("/{idPet}")
    public void delete(@PathVariable("idPet") Integer idPessoa)throws RegraDeNegocioException{
        petService.delete(idPessoa);
    }

}
