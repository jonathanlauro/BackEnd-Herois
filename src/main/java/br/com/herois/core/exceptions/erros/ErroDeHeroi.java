package br.com.herois.core.exceptions.erros;

import br.com.herois.core.exceptions.EnumeradoDeErro;

import javax.ws.rs.core.Response.*;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

public enum ErroDeHeroi implements EnumeradoDeErro {

    HEROI_NAO_ENCONTRADO(
            "Herói não encontrado.",
            NOT_FOUND
    ),
    NOME_HEROI(
            "O nome do herói não pode ser nulo ou vazio.",
            BAD_REQUEST
    ),
    IDADE_HEROI(
            "O idade do herói não pode ser nulo.",
            BAD_REQUEST
    ),
    FORCA_HEROI(
            "O forca do herói não pode ser nulo.",
            BAD_REQUEST
    ),
    ID_HEROI(
            "O Id do herói não pode ser nulo.",
            BAD_REQUEST
    )
    ;

    private final String menssage;

    private final Status status;

    ErroDeHeroi(String menssage, Status status) {
        this.menssage = menssage;
        this.status = status;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String getMenssagem() {
        return menssage;
    }
}
