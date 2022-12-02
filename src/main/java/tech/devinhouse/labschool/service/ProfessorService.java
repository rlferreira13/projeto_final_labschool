package tech.devinhouse.labschool.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool.model.Estado;
import tech.devinhouse.labschool.model.Professor;
import tech.devinhouse.labschool.repository.ProfessorRepository;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProfessorService {

    private ProfessorRepository repo;

    public Professor criar (Professor professor){
        boolean existe = repo.existsByCpf(professor.getCpf());
        if (existe){
            throw new RuntimeException("Usuário já cadastrado.");
        }
        professor = repo.save(professor);
        return professor;
    }
    public Professor atualizar(Professor professor) {
        Optional<Professor> professorOpt = repo.findById(professor.getCodigo());
        if (professorOpt.isEmpty())
            throw new InputMismatchException("Perfil não encontrado");
        Professor professorBD = professorOpt.get();
        professorBD.setEstado(professor.getEstado());
        repo.save(professorBD);
        return professorBD;
    }
    public List<Professor> listarProfessores(){
        return repo.findAll();
    }
    public List<Professor> listarProfessoresPorEstado (String estado){
        Estado situacaoestado = Estado.valueOf(estado.toUpperCase());
        return repo.findByestado(situacaoestado);
    }
    public void deletarProfessor(Integer codigo) {
        if (!repo.existsById(codigo))
            throw new InputMismatchException("Professor não existe");
        repo.deleteById(codigo);
    }
    public Professor listarProfessorPorId(Integer codigo) {
        return repo.findByCodigo(codigo);
    }
}
