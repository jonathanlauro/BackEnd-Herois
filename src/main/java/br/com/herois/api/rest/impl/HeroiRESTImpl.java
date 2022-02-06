package br.com.herois.api.rest.impl;

import br.com.herois.api.conversor.ConversorDeHeroi;
import br.com.herois.api.model.HeroiModelo;
import br.com.herois.api.rest.HeroiREST;
import br.com.herois.core.entity.Heroi;
import br.com.herois.core.exceptions.BaseException;
import br.com.herois.core.service.HeroiService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class HeroiRESTImpl implements HeroiREST {

   @Inject
    private HeroiService service;

    @Inject
    private ConversorDeHeroi conversor;

    @Override
    public Response listar() {
        return Response.ok(
                conversor.toListaModelo(service.listar())
        ).build();
    }

    @Override
    public Response cadastrar(HeroiModelo heroi) throws BaseException {
        return Response.ok(
                conversor.toModelo(service.cadastrar(conversor.toEntidade(heroi)))
        ).build();
    }

    @Override
    public HeroiModelo atualizar(Heroi heroi) {
        return null;
    }

    @Override
    public Response delete(Long id) throws BaseException {
        return Response.ok(
                conversor.toModelo(service.deletar(id))
        ).build();
    }
}
