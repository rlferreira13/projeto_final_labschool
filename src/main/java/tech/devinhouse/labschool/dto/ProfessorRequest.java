package tech.devinhouse.labschool.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class ProfessorRequest {

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
        private long cpf;

        @NotNull
      @Enumerated(EnumType.STRING)
        private String formacao;

        @NotNull
        @Enumerated(EnumType.STRING)
        private String experiencia;

        @NotNull
        @Enumerated(EnumType.STRING)
        private String estado;

}
