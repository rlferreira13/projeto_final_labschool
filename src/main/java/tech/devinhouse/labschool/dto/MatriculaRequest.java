package tech.devinhouse.labschool.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class MatriculaRequest {
    @Pattern(regexp = "ATIVO|IRREGULAR|ATENDIMENTO_PEDAGOGICO|INATIVO", flags = Pattern.Flag.CASE_INSENSITIVE, message = "{campo.invalido}")
    private String situacao;
}
