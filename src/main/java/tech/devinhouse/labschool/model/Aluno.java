package tech.devinhouse.labschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ALUNOS")


public class Aluno extends Pessoa{

    @Enumerated(EnumType.STRING)
    private SituacaoMatricula situacao;

    @Column(name="atendimentos")
    private Integer atendimentosPedagogicos = 0;

    private Float nota;

    public Aluno(String nome, String telefone, LocalDate dataNascimento, Long cpf, SituacaoMatricula situacao, Float nota) {
        super(nome,telefone,dataNascimento,cpf);
        this.situacao = situacao;
        this.nota = nota;
    }

}
