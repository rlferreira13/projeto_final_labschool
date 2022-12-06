package tech.devinhouse.labschool.dto;

import lombok.Data;

import java.time.LocalDate;

@Data

public class PedagogoResponse {

    private Integer codigo;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private long cpf;
    private Integer atendimentosPedagogicos;

}
