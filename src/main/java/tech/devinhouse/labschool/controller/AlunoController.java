package tech.devinhouse.labschool.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschool.dto.AlunoRequest;
import tech.devinhouse.labschool.dto.AlunoResponse;
import tech.devinhouse.labschool.dto.MatriculaRequest;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.service.AlunoService;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
@Validated
public class AlunoController {
    private AlunoService service;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<AlunoResponse> criar(@RequestBody @Valid AlunoRequest request){
        Aluno aluno = mapper.map (request, Aluno.class);
        aluno = service.criar(aluno);
        AlunoResponse resp = mapper.map (aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp);
    }
    @PutMapping("{codigo}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable("codigo")Integer codigo, @RequestBody @Valid MatriculaRequest situacao) {
        Aluno aluno = mapper.map(situacao, Aluno.class);
        aluno.setCodigo(codigo);
        aluno = service.atualizar(aluno);
        AlunoResponse resp = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(resp);
    }
    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listarAlunos(@RequestParam  (value = "situacao",required = false)String situacao){
        List<Aluno>alunos;
        if (situacao == null)
            alunos = service.listarAlunos();
        else
            alunos = service.listarAlunosPorSituacao(situacao);
        List<AlunoResponse>resp = new ArrayList<>();
        for (Aluno aluno:alunos){
            AlunoResponse alunoResponse = mapper.map(aluno, AlunoResponse.class);
            resp.add(alunoResponse);
        }
        return ResponseEntity.ok(resp);
    }
    @GetMapping("{codigo}")
    public ResponseEntity<AlunoResponse> listarAlunos(@PathVariable("codigo")  Integer codigo){
        Aluno aluno = service.listarAlunoPorId(codigo);
        AlunoResponse resp = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(resp);
    }
    @DeleteMapping("{codigo}")
    public ResponseEntity<AlunoResponse> deletarAluno(@PathVariable("codigo")  Integer codigo){
        service.deletarAluno(codigo);
        return ResponseEntity.noContent().build();
    }


}
