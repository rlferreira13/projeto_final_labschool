package tech.devinhouse.labschool.exception;

public class RegistroExistenteException extends RuntimeException {

    public RegistroExistenteException(String nomeRecurso, String id) {
        super(nomeRecurso + " com CPF " + id + " já existente!");
    }

    public RegistroExistenteException(String nomeRecurso, Long id) {
        this(nomeRecurso, String.valueOf(id));
    }

}