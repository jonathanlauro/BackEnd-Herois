package br.com.herois.api.model;

import javax.ws.rs.core.Response;
import java.io.Serializable;

public class ErroModelo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String menssage;

    private Throwable causa;

    private Response.Status status;

    public ErroModelo() {
        this(null,null,null);
    }

    public ErroModelo(String menssage, Throwable causa, Response.Status status) {
        this.menssage = menssage;
        this.causa = causa;
        this.status = status;
    }

    public String getMenssage() {
        return menssage;
    }

    public Throwable getCausa() {
        return causa;
    }

    @Override
    public String toString() {
        return "{" +
                "\"menssagem:\"" + menssage + "\"," +
                "\"causa:\"" + causa + "\"" +
                '}';
    }
}
