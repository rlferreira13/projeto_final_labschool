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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PEDAGOGOS")
public class Pedagogo extends Pessoa{

    @Column (name ="atendimentos")
    private Integer totaldeAtendimentosPedagogicosRealizados;

    public Pedagogo(@NotNull String nome, @NotNull String telefone, @NotNull LocalDate dataNascimento, @NotNull Long cpf, Integer totaldeAtendimentosPedagogicosRealizados) {
        super(nome, telefone, dataNascimento, cpf);
        this.totaldeAtendimentosPedagogicosRealizados = totaldeAtendimentosPedagogicosRealizados;
    }
}
