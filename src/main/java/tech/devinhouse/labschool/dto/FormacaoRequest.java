package tech.devinhouse.labschool.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class FormacaoRequest {
    @Pattern(regexp = "GRADUACAO_INCOMPLETA | GRADUACAO_COMPLETA | MESTRADO | DOUTORADO", flags = Pattern.Flag.CASE_INSENSITIVE, message = "{campo.invalido}")
    private String formacao;
}
