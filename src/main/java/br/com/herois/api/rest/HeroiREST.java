package br.com.herois.api.rest;

import br.com.herois.api.model.HeroiModelo;
import br.com.herois.core.entity.Heroi;
import br.com.herois.core.exceptions.BaseException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/herois")
public interface HeroiREST {

    @GET
    @Produces(value = APPLICATION_JSON)
    Response listar();

    @POST
    @Produces(value = APPLICATION_JSON)
    Response cadastrar(HeroiModelo heroi) throws BaseException;

    @PUT
    @Produces(value = APPLICATION_JSON)
    HeroiModelo atualizar(Heroi heroi);

    @DELETE
    @Path("/{id}")
    @Produces(value = APPLICATION_JSON)
    Response delete(@PathParam("id") Long id) throws BaseException;
}
