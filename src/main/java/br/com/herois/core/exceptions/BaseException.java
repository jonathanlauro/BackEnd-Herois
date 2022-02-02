package br.com.herois.core.exceptions;

import javax.ws.rs.core.Response.Status;

public class BaseException extends Exception{

    private static final long serialVersionUID = 1L;
    private final Status status;
    private static final String MENSSAGEM = "Ocorreu um erro no processamento do sistema. ";

    protected  BaseException(String menssagem,Status status, Throwable causa){
        super(
               menssagem == null ? MENSSAGEM : menssagem, causa
        );
        this.status = status;
    }


    public Status getStatus() {
        return status;
    }
}
