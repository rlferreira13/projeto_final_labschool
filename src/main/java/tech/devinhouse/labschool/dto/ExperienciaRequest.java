package tech.devinhouse.labschool.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ExperienciaRequest {
    @Pattern(regexp = "FRONT_END|BACK_END|FULL_STACK", flags = Pattern.Flag.CASE_INSENSITIVE, message = "{campo.invalido}")
    private String experiencia;
}
