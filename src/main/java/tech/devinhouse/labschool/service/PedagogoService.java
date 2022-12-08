package tech.devinhouse.labschool.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschool.exception.RegistroExistenteException;
import tech.devinhouse.labschool.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschool.model.Pedagogo;
import tech.devinhouse.labschool.repository.PedagogoRepository;
import java.util.InputMismatchException;
import java.util.List;


@Service
@AllArgsConstructor

public class PedagogoService {

    private PedagogoRepository repo;

    public Pedagogo criar (Pedagogo pedagogo){
        boolean existe = repo.existsByCpf(pedagogo.getCpf());
        if (existe){
            throw new RegistroExistenteException("Pedagogo",pedagogo.getCpf());
        }
        pedagogo = repo.save(pedagogo);
        return pedagogo;
    }
    public List<Pedagogo> listarPedagogos(){
        return repo.findAll();
    }
    public void deletarPedagogo(Integer codigo) {
        if (!repo.existsById(codigo))
            throw new RegistroNaoEncontradoException("Pedagogo",codigo);
        repo.deleteById(codigo);
    }
    public Pedagogo listarPedagogosPorId(Integer codigo) {
        return repo.findByCodigo(codigo);
    }
}
