package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;


    public List<ProfessorEntity> list(){
        return professorRepository.findAll();
    }
}
