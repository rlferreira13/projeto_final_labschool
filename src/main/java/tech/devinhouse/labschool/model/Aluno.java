package tech.devinhouse.labschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ALUNOS")
@AllArgsConstructor
@NoArgsConstructor

public class Aluno extends Pessoa{

    public Aluno(@NotNull String nome, @NotNull String telefone, @NotNull LocalDate dataNascimento, @NotNull Long cpf, Integer codigo, SituacaoMatricula situacao, Integer atendimentosPedagogicos, Float nota) {
        super(nome, telefone, dataNascimento, cpf, codigo);
        this.situacao = situacao;
        this.atendimentosPedagogicos = atendimentosPedagogicos;
        this.nota = nota;
    }

    @Column (name="situacao")
    @NotNull
    private SituacaoMatricula situacao;

    @Column (name="atendimentos")
    private Integer atendimentosPedagogicos = 0;

    @Column (name = "nota")
    @NotNull
    private Float nota;

    public SituacaoMatricula getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoMatricula situacao) {
        this.situacao = situacao;
    }
}
