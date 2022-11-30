package tech.devinhouse.labschool.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.model.SituacaoMatricula;
import tech.devinhouse.labschool.repository.AlunoRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AlunoService {

    private AlunoRepository repo;

    public Aluno criar (Aluno aluno){
        boolean existe = repo.existsByCpf(aluno.getCpf());
        if (existe){
            throw new RuntimeException("Usuário já cadastrado.");
        }
        aluno = repo.save(aluno);
        return aluno;
    }

    public Aluno atualizar(Aluno aluno) {
        Optional<Aluno> alunoOpt = repo.findById(aluno.getCodigo());
        if (alunoOpt.isEmpty())
            throw new InputMismatchException("Perfil não encontrado");
        Aluno alunoBD = alunoOpt.get();
        alunoBD.setSituacao(aluno.getSituacao());
        repo.save(alunoBD);
        return alunoBD;
    }
    public List<Aluno> listarAlunos(){
        List<Aluno>listaAlunos = repo.findAll();
        return listaAlunos;
    }
    }
