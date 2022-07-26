package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.PessoaCompletoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.RelatorioPersonalizadoDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.ProfessorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNome(String nome);
    List<PessoaEntity> findByNomeStartingWithIgnoreCase(String nome);

//    @Query("select from ")
    List<PessoaEntity> findPessoaByidPessoaLike(Integer idPessoa);

    PessoaEntity findByCpf(String cpf);

    public List<PessoaEntity> findAllByDataNascimentoBetween(LocalDate dtIni, LocalDate dtFin);

    @Query(value = " select new br.com.vemser.pessoaapi.dto.RelatorioPersonalizadoDTO(" +
            " p.idPessoa," +
            " p.nome," +
            " p.email," +
            " c.numero," +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " petty.nome)" +

            "  from PESSOA p " +
            "  left join p.enderecosPessoa e " +
            "  left join p.contatosPessoa c " +
            "  left join p.petPessoa petty " +

            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    public Page<RelatorioPersonalizadoDTO> relatorioPersonalizadoDTO(@Param("idPessoa") Integer idPessoa, Pageable pageable9);

//    @Query(value = " select new br.com.vemser.pessoaapi.dto.PessoaCompletoDTO(" +
//            " pc.nome," +
//            " pc.email," +
//            " pc.dataNascimento," +
//            " e.cep," +
//            " e.cidade," +
//            " e.estado," +
//            " e.pais," +
//            " petty.nome)" +
//
//            "  from PESSOA p " +
//            "  left join p.enderecosPessoa e " +
//            "  left join p.contatosPessoa c " +
//            "  left join p.petPessoa petty " +
//
//            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
//    public Set<PessoaCompletoDTO> listarPessoaCompleta(Integer idPessoa);

}
