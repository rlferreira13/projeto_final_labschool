package tech.devinhouse.labschool.dto;

import lombok.Data;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.model.Pedagogo;

@Data
public class AtendimentoPedagogicoRequest {

    private Integer codigoAluno;
    private Integer codigoPedagogo;
    
}
