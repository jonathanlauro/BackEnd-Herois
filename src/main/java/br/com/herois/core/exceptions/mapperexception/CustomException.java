package br.com.herois.core.exceptions.mapperexception;

import br.com.herois.api.model.ErroModelo;
import br.com.herois.core.exceptions.BaseException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomException implements ExceptionMapper<BaseException> {

    @Override
    public Response toResponse(BaseException e) {
        ErroModelo erro = new ErroModelo(e.getMessage(), e.fillInStackTrace(),e.getStatus());

        return Response.status(e.getStatus()).type(MediaType.APPLICATION_JSON).entity(erro).build();
    }
}
