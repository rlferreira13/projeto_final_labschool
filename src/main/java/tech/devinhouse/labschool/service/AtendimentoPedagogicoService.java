package tech.devinhouse.labschool.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.model.Pedagogo;
import tech.devinhouse.labschool.model.SituacaoMatricula;
import tech.devinhouse.labschool.repository.AlunoRepository;
import tech.devinhouse.labschool.repository.PedagogoRepository;

@AllArgsConstructor
@Service



public class AtendimentoPedagogicoService {

    private ModelMapper mapper;

    private PedagogoRepository pedagogoRepository;

    private AlunoRepository alunoRepository;

    public Boolean cadastrarAtendimentoPedagogico(Integer codigoAluno, Integer codigoPedagogo){
        if (!alunoRepository.existsByCodigo(codigoAluno) || !pedagogoRepository.existsByCodigo(codigoPedagogo)){
            throw new RuntimeException("Não há registros de usuários com esse ID");
        }
        Aluno aluno = alunoRepository.findById(codigoAluno).get();
        aluno.setSituacao(SituacaoMatricula.ATENDIMENTO_PEDAGOGICO);
        aluno.setAtendimentosPedagogicos(aluno.getAtendimentosPedagogicos()+1);
        alunoRepository.save(aluno);

        Pedagogo pedagogo = pedagogoRepository.findById(codigoPedagogo).get();
        pedagogo.setTotaldeAtendimentosPedagogicosRealizados(pedagogo.getTotaldeAtendimentosPedagogicosRealizados()+1);
        pedagogoRepository.save(pedagogo);
        return true;
    }
}


