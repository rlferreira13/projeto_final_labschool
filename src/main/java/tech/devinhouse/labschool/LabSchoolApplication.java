package tech.devinhouse.labschool;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.devinhouse.labschool.model.*;
import tech.devinhouse.labschool.service.AlunoService;
import tech.devinhouse.labschool.service.PedagogoService;
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
                alunoService.criar(new Aluno("Bart Simpson", "11-11111-1212", LocalDate.of(2014,10,29), 11839750073L, SituacaoMatricula.IRREGULAR,3.5F));
                alunoService.criar(new Aluno("Lisa Simpson", "11-22222-2222", LocalDate.of(2012,10,29), 17158947076L, SituacaoMatricula.ATIVO,10F));
                alunoService.criar(new Aluno("Meggie Simpson", "12-20002-2200", LocalDate.of(2019,10,29), 63701210020L, SituacaoMatricula.ATIVO,9F));
                alunoService.criar(new Aluno("Milhouse Van Houten", "11-33333-2222", LocalDate.of(2014,10,29), 30119137062L, SituacaoMatricula.ATIVO,8F));
                alunoService.criar(new Aluno("Nelson Muntz", "11-44333-4444", LocalDate.of(2007,10,29), 95704094015L, SituacaoMatricula.INATIVO,2F));

            }
        };
    }

    @Bean
    CommandLineRunner run2(ProfessorService professorService) {
        return args -> {
            List<Professor> lista = professorService.listarProfessores();
            if (lista.isEmpty()) {
                professorService.criar(new Professor("Walter White","14-22998-1882",LocalDate.of(1982,10,30),40539019011L, FormacaoAcademica.MESTRADO, ExperienciaEmDesenvolvimento.FULL_STACK,Estado.ATIVO));
                professorService.criar(new Professor("Jesse Pinkman","44-11111-1992",LocalDate.of(1997,10,30),96107295097L, FormacaoAcademica.GRADUACAO_INCOMPLETA, ExperienciaEmDesenvolvimento.BACK_END,Estado.ATIVO));
                professorService.criar(new Professor("Hank Schrader","44-11111-1002",LocalDate.of(1984,10,30),70685977005L, FormacaoAcademica.MESTRADO, ExperienciaEmDesenvolvimento.FULL_STACK,Estado.ATIVO));
                professorService.criar(new Professor("Gustavo Fring","44-11001-1002",LocalDate.of(1977,10,30),57408927085L, FormacaoAcademica.GRADUACAO_COMPLETA, ExperienciaEmDesenvolvimento.FRONT_END,Estado.INATIVO));
                professorService.criar(new Professor("Saul Goodman","44-11998-1882",LocalDate.of(1980,10,30),86940162062L, FormacaoAcademica.MESTRADO, ExperienciaEmDesenvolvimento.FULL_STACK,Estado.ATIVO));
            }
        };
    }

    @Bean
    CommandLineRunner run3(PedagogoService pedagogoService) {
        return args -> {
            List<Pedagogo> lista = pedagogoService.listarPedagogos();
            if (lista.isEmpty()) {
                pedagogoService.criar(new Pedagogo("John Snow","11-67333-4454",LocalDate.of(2000,10,30),62316840086L,0));
                pedagogoService.criar(new Pedagogo("Sansa Stark","22-22333-4454",LocalDate.of(2004,10,30),49850253053L,0));
                pedagogoService.criar(new Pedagogo("Tyrion Lannister","33-77333-4454",LocalDate.of(1990,10,30),39125106015L,0));
                pedagogoService.criar(new Pedagogo("Sandor Clegane","11-33333-2222",LocalDate.of(1995,10,30),89089606009L,0));
            }
        };
    }
}