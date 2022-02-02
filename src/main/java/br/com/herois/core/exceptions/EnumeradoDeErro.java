package br.com.herois.core.exceptions;

import javax.ws.rs.core.Response;

public interface EnumeradoDeErro {

    Response.Status getStatus();

    String getMenssagem();

}
