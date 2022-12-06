package tech.devinhouse.labschool.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschool.dto.PedagogoRequest;
import tech.devinhouse.labschool.dto.PedagogoResponse;
import tech.devinhouse.labschool.dto.MatriculaRequest;
import tech.devinhouse.labschool.model.Pedagogo;
import tech.devinhouse.labschool.service.PedagogoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/pedagogos")
@AllArgsConstructor
@Validated
public class PedagogoController {
    public PedagogoService service;
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<PedagogoResponse> criar(@RequestBody @Valid PedagogoRequest request){
        Pedagogo pedagogo = mapper.map (request, Pedagogo.class);
        pedagogo = service.criar(pedagogo);
        PedagogoResponse resp = mapper.map (pedagogo, PedagogoResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp)   ;
    }

    @GetMapping
    public ResponseEntity<List<PedagogoResponse>> listarPedagogos(){
        List<Pedagogo>pedagogos;
            pedagogos = service.listarPedagogos();
        List<PedagogoResponse>resp = new ArrayList<>();
        for (Pedagogo pedagogo:pedagogos){
            PedagogoResponse pedagogoResponse = mapper.map(pedagogo, PedagogoResponse.class);
            resp.add(pedagogoResponse);
        }
        return ResponseEntity.ok(resp);
    }
    @GetMapping("{codigo}")
    public ResponseEntity<PedagogoResponse> listarPedagogos(@PathVariable("codigo")  Integer codigo){
        Pedagogo pedagogo = service.listarPedagogosPorId(codigo);
        PedagogoResponse resp = mapper.map(pedagogo, PedagogoResponse.class);
        return ResponseEntity.ok(resp);
    }
    @DeleteMapping("{codigo}")
    public ResponseEntity<PedagogoResponse> deletarPedagogo(@PathVariable("codigo")  Integer codigo){
        service.deletarPedagogo(codigo);
        return ResponseEntity.noContent().build();
    }


}
