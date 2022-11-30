package tech.devinhouse.labschool;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.model.SituacaoMatricula;
import tech.devinhouse.labschool.service.AlunoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class LabSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSchoolApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
////    @Bean
////    CommandLineRunner run(AlunoService alunoService) {
////        return args -> {
////            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
////            alunoService.criar(new Aluno("Bart Simpson","11-11111-1212", LocalDate.parse("2014-10-29",formatador),11839750073L, SituacaoMatricula.IRREGULAR,3.5F));
////
////        };
//
//
//}
}
