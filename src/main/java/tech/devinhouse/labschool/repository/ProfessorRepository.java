package tech.devinhouse.labschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschool.model.Estado;
import tech.devinhouse.labschool.model.Professor;

import java.util.List;


@Repository

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    boolean existsByCpf(Long cpf);

    Professor findByCodigo(Integer codigo);

    List<Professor> findByestado(Estado estado);
}
