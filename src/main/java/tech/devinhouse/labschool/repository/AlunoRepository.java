package tech.devinhouse.labschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschool.model.Aluno;


@org.springframework.stereotype.Repository

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    boolean existsByCpf(Long cpf);
}
