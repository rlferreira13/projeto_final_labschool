package tech.devinhouse.labschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labschool.model.Pedagogo;


@Repository

public interface PedagogoRepository extends JpaRepository<Pedagogo, Integer> {

    boolean existsByCpf(Long cpf);

    Pedagogo findByCodigo(Integer codigo);

    Boolean existsByCodigo(Integer codigo);

}
