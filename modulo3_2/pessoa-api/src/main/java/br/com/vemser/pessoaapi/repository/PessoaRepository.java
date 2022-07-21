package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNome(String nome);
    List<PessoaEntity> findByNomeStartingWithIgnoreCase(String nome);

//    @Query("select from ")
    List<PessoaEntity> findPessoaByidPessoaLike(Integer idPessoa);
    PessoaEntity findByCpf(String cpf);

    List<PessoaEntity> findAllByDataNascimentoBetween(LocalDate dtIni, LocalDate dtFin);

    //LISTAR PESSOA COMPLETA - HOMEWORK
/*    @Query(value = " select new br.com.vemser.pessoaapi.dto.RelatorioPersonalizadoDTO(" +
            " p.idPessoa," +
            " p.nome," +
            " p.email," +
            " c.numero," +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " petz.nome" +

            ")" +
            "  from PESSOA p " +
            "  left join p.enderecos e " +
            "  left join p.contatos c " +
            "  left join p.pet petz " +

            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<RelatorioPersonalizadoDTO> relatorioPersonalizadoDTO(@Param("idPessoa") Integer idPessoa);*/



}
