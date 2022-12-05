package tech.devinhouse.labschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
@Data
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor

public class Pessoa {
    @NotNull
    private String nome;

    @NotNull
    private String telefone;

    @Column (name ="data_nascimento")
    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private Long cpf;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer codigo;

    public Pessoa(String nome, String telefone, LocalDate dataNascimento, Long cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }
}
