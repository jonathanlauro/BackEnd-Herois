package br.com.herois.core.produces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface ProdutorDeEntidade {

    EntityManager getGerenciador();

    EntityManagerFactory getContexto();
}
