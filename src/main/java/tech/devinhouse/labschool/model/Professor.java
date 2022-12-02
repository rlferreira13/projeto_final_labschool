package tech.devinhouse.labschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROFESSORES")
public class Professor extends Pessoa {

    @Enumerated
    @Column(name = "formacao")
    private FormacaoAcademica formacao;

    public Professor(@NotNull String nome, @NotNull String telefone, @NotNull LocalDate dataNascimento, @NotNull Long cpf, FormacaoAcademica formacao, ExperienciaEmDesenvolvimento experiencia, Estado estado) {
        super(nome, telefone, dataNascimento, cpf);
        this.formacao = formacao;
        this.experiencia = experiencia;
        this.estado = estado;
    }

    @Enumerated
    private ExperienciaEmDesenvolvimento experiencia;

    @Enumerated
    private Estado estado;

}
