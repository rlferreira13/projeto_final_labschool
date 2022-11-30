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
import java.util.List;


@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
@Validated
public class AlunoController {
    public AlunoService service;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<AlunoRequest> criar(@RequestBody @Valid AlunoRequest request){
        Aluno aluno = mapper.map (request, Aluno.class);
        aluno = service.criar(aluno);
        AlunoResponse resp = mapper.map (aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(request);
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
    public List<Aluno> listarAlunos(){
        return service.listarAlunos();
    }

}
