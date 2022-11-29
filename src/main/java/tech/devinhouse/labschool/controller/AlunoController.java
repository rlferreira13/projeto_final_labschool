package tech.devinhouse.labschool.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.model.SituacaoMatricula;
import tech.devinhouse.labschool.service.AlunoService;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
@Validated
public class AlunoController {
    public AlunoService service;
    //private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody @Valid Aluno aluno){
        aluno = service.criar(aluno);
        return ResponseEntity.created(URI.create(aluno.getNome())).body(aluno);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Aluno> atualizar(@PathVariable("codigo") SituacaoMatricula situacao, @RequestBody @Valid Aluno aluno) {
        aluno.setSituacao(situacao);
        aluno = service.atualizar(aluno);
        return ResponseEntity.ok(aluno);
    }
}
