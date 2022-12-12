package tech.devinhouse.labschool.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschool.dto.*;
import tech.devinhouse.labschool.service.AlunoService;
import tech.devinhouse.labschool.service.AtendimentoPedagogicoService;
import tech.devinhouse.labschool.service.PedagogoService;


@RestController
@RequestMapping("api/atendimentos")
@AllArgsConstructor
public class AtendimentoPedagogicoController {

    private AtendimentoPedagogicoService service;
    private AlunoService alunoService;
    private PedagogoService pedagogoService;

    @PutMapping
    public ResponseEntity<AtendimentoPedagogicoResponse> cadastrarAtendimentoPedagogico(@RequestBody AtendimentoPedagogicoRequest request){
        Boolean operacaoComSucesso = service.cadastrarAtendimentoPedagogico(request.getCodigoAluno(), request.getCodigoPedagogo());
        AtendimentoPedagogicoResponse response = new AtendimentoPedagogicoResponse();

        if (!operacaoComSucesso){
            return ResponseEntity.notFound().build();
        }
        response.setAluno(alunoService.listarAlunoPorId(request.getCodigoAluno()));
        response.setPedagogo(pedagogoService.listarPedagogosPorId(request.getCodigoPedagogo()));

        return ResponseEntity.ok(response);
    }




}
