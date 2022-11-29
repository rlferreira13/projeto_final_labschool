package tech.devinhouse.labschool.Model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ALUNOS")

public class Aluno extends Pessoa{
    private SituacaodaMatricula situacaoDaMatricula;
    private Double nota;
    private Integer atendimentosPedagogicos = 0;
    @Id
    private Long id;


}
