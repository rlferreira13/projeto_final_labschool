package tech.devinhouse.labschool.dto;

import lombok.Data;
import tech.devinhouse.labschool.model.ExperienciaEmDesenvolvimento;
import tech.devinhouse.labschool.model.FormacaoAcademica;

import java.time.LocalDate;

@Data

public class ProfessorResponse {

    private Integer codigo;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private long cpf;
    private FormacaoAcademica formacao;
    private ExperienciaEmDesenvolvimento experiencia;
    private EstadoRequest estado;

}
