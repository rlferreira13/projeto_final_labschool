package tech.devinhouse.labschool.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class EstadoRequest {
    @Pattern(regexp = "ATIVO|INATIVO", flags = Pattern.Flag.CASE_INSENSITIVE, message = "{campo.invalido}")
    private String estado;
}
