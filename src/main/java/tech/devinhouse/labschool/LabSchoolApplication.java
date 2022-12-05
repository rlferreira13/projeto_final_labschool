package tech.devinhouse.labschool;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.devinhouse.labschool.model.*;
import tech.devinhouse.labschool.service.AlunoService;
import tech.devinhouse.labschool.service.ProfessorService;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class LabSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSchoolApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner run(AlunoService alunoService) {
        return args -> {
            List<Aluno> lista = alunoService.listarAlunos();
            if (lista.isEmpty()) {
                alunoService.criar(new Aluno("Lorenzzo", "47 3333-3333", LocalDate.of(2009,3,29), 11234567891L, SituacaoMatricula.ATIVO,7.5F));
                alunoService.criar(new Aluno("Wanessa", "47 3333-3333", LocalDate.of(1990,5,11), 201302103211L, SituacaoMatricula.INATIVO,7F));
                alunoService.criar(new Aluno("Ricardo", "47 3333-3333", LocalDate.of(1990,9,13), 37234567820L, SituacaoMatricula.IRREGULAR,10F));
            }
        };
    }

    @Bean
    CommandLineRunner run2(ProfessorService professorService) {
        return args -> {
            List<Professor> lista = professorService.listarProfessores();
            if (lista.isEmpty()) {
                professorService.criar(new Professor("Marcio","47 3333-3333",LocalDate.of(1966,7,1),12345678910L, FormacaoAcademica.MESTRADO, ExperienciaEmDesenvolvimento.FRONT_END,Estado.ATIVO));
                professorService.criar(new Professor("Ivany","47 3333-3333",LocalDate.of(1947,7,6),109876543210L, FormacaoAcademica.GRADUACAO_INCOMPLETA, ExperienciaEmDesenvolvimento.BACK_END,Estado.ATIVO));
                professorService.criar(new Professor("Edil","47 3333-3333",LocalDate.of(1966,7,1),10203040501L, FormacaoAcademica.DOUTORADO, ExperienciaEmDesenvolvimento.FULL_STACK,Estado.ATIVO));
            }
        };
    }
}