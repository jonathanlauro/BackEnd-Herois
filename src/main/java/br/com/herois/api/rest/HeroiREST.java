package br.com.herois.api.rest;

import br.com.herois.api.conversor.ConversorDeHeroi;
import br.com.herois.api.model.HeroiModelo;
import br.com.herois.core.entity.Heroi;
import br.com.herois.core.exceptions.BaseException;
import br.com.herois.core.service.HeroiService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/herois")
public class HeroiREST {

    @Inject
    private HeroiService service;

    @Inject
    private ConversorDeHeroi converor;

    @GET
    @Produces(value = APPLICATION_JSON)
    public Response listar(){
        return Response.ok(
                converor.toListaModelo(service.listar())
        ).build();
    }

    @POST
    @Produces(value = APPLICATION_JSON)
    public Response cadastrar(HeroiModelo heroi) throws BaseException{
        return Response.ok(
                converor.toModelo(service.cadastrar(converor.toEntidade(heroi)))
        ).build();
    }

    @PUT
    @Produces(value = APPLICATION_JSON)
    public HeroiModelo atualizar(Heroi heroi){
        return null;
    }
    @DELETE
    @Path("/{id}")
    @Produces(value = APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) throws BaseException {
        return Response.ok(
                converor.toModelo(service.deletar(id))
        ).build();
    }
}
