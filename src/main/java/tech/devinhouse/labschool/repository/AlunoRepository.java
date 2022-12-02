package tech.devinhouse.labschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.model.SituacaoMatricula;

import java.util.List;


@Repository

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    boolean existsByCpf(Long cpf);

    List<Aluno> findBySituacao(SituacaoMatricula situacao);
}
