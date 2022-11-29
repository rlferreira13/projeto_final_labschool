package tech.devinhouse.labschool.Model;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)

public class Pessoa {
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private Long cpf;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer codigo;
}
