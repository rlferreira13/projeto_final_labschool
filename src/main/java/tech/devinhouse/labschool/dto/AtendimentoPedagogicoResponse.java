package tech.devinhouse.labschool.dto;

import lombok.Data;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.model.Pedagogo;

@Data
public class AtendimentoPedagogicoResponse {

    private Aluno aluno;
    private Pedagogo pedagogo;

}
