package tech.devinhouse.labschool.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschool.dto.*;
import tech.devinhouse.labschool.model.Professor;
import tech.devinhouse.labschool.service.ProfessorService;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/professor")
@AllArgsConstructor
@Validated
public class ProfessorController {
    public ProfessorService service;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<ProfessorResponse> criar(@RequestBody @Valid ProfessorRequest request){
        Professor professor = mapper.map (request, Professor.class);
        professor = service.criar(professor);
        ProfessorResponse resp = mapper.map (professor, ProfessorResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp)   ;
    }
    @PutMapping("{codigo}")
    public ResponseEntity<ProfessorResponse> atualizar(@PathVariable("codigo")Integer codigo, @RequestBody @Valid ProfessorRequest estado) {
        Professor professor = mapper.map(estado, Professor.class);
        professor.setCodigo(codigo);
        professor = service.atualizar(professor);
        ProfessorResponse resp = mapper.map(professor, ProfessorResponse.class);
        return ResponseEntity.ok(resp);
    }
    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> listarProfessor(@RequestParam  (value = "estado",required = false)String estado){
        List<Professor>professores;
        if (estado == null)
            professores = service.listarProfessores();
        else
            professores = service.listarProfessoresPorEstado(estado);
        List<ProfessorResponse>resp = new ArrayList<>();
        for (Professor professor:professores){
            ProfessorResponse professorResponse = mapper.map(professor, ProfessorResponse.class);
            resp.add(professorResponse);
        }
        return ResponseEntity.ok(resp);
    }
    @GetMapping("{codigo}")
    public ResponseEntity<ProfessorResponse> listarProfessor(@PathVariable("codigo")  Integer codigo){
        Professor professor = service.listarProfessorPorId(codigo);
        ProfessorResponse resp = mapper.map(professor, ProfessorResponse.class);
        return ResponseEntity.ok(resp);
    }
    @DeleteMapping("{codigo}")
    public ResponseEntity<ProfessorResponse> deletarProfessor(@PathVariable("codigo")  Integer codigo){
        service.deletarProfessor(codigo);
        return ResponseEntity.noContent().build();
    }


}
