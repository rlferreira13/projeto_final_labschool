package tech.devinhouse.labschool.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import tech.devinhouse.labschool.model.SituacaoMatricula;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PedagogoRequest {

        @NotNull
        @Enumerated(EnumType.STRING)
        private SituacaoMatricula situacao;

        @NotNull
        @Min(value=0)
        @Max(value=10)
        private Float nota;

        @NotEmpty
        private String nome;

        @NotEmpty
        private String telefone;

        @Past
        @DateTimeFormat(pattern = "yyyy/MM/dd")
        @Column (name ="data_nascimento")
        @NotNull
        private LocalDate dataNascimento;

        @NotNull
        private Long cpf;
        

}
