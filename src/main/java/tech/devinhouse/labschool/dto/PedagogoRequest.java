package tech.devinhouse.labschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PedagogoRequest {

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

        @NotNull
        @Column (name ="atendimentos")
        private Integer totaldeAtendimentosPedagogicosRealizados;
}
