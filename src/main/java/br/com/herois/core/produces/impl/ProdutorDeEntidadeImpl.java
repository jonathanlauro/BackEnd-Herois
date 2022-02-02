package br.com.herois.core.produces.impl;

import br.com.herois.core.produces.ProdutorDeEntidade;

import javax.ejb.Local;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.ext.Provider;

@Provider
@Local(ProdutorDeEntidade.class)
public class ProdutorDeEntidadeImpl implements ProdutorDeEntidade {

    @PersistenceContext(unitName = "herois")
    private EntityManager gerenciador;

    @PersistenceUnit(unitName = "herois")
    private EntityManagerFactory contexto;

    @Produces
    @Override
    public EntityManager getGerenciador() {
        return gerenciador;
    }

    @Produces
    @Override
    public EntityManagerFactory getContexto() {
        return contexto;
    }
}
