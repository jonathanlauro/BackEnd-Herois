package br.com.herois.core.repository.impl;

import br.com.herois.core.entity.Heroi;
import br.com.herois.core.exceptions.NegocioException;
import br.com.herois.core.repository.RepositorioDeHeroi;

import javax.ejb.Local;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static br.com.herois.core.exceptions.erros.ErroDeHeroi.HEROI_NAO_ENCONTRADO;
import static java.util.Objects.nonNull;

@RequestScoped
@Local(RepositorioDeHeroi.class)
public class RepositorioDeHeroiEJB implements RepositorioDeHeroi {

    @Inject
    private EntityManager gerenciador;

    @Override
    public Heroi cadastrar(Heroi heroi) {
        gerenciador.persist(heroi);
        gerenciador.flush();
        return heroi;
    }

    @Override
    public Heroi atualizar(Heroi heroi) {
        Heroi atualizado = carregar(heroi.getId());
        if(nonNull(atualizado)){
            atualizado.setForca(heroi.getForca());
            atualizado.setIdade(heroi.getIdade());
            atualizado.setNome(heroi.getNome());
            gerenciador.merge(atualizado);
            gerenciador.flush();
            return atualizado;
        }
        return null;
    }

    @Override
    public Heroi deletar(Long id) throws NegocioException {
        Heroi deletado = carregar(id);
        gerenciador.remove(deletado);
        gerenciador.flush();
        return deletado;
    }

    @Override
    public List<Heroi> findAll() {
        CriteriaBuilder cb = gerenciador.getCriteriaBuilder();
        CriteriaQuery<Heroi> cq = cb.createQuery(Heroi.class);
        Root<Heroi> root = cq.from(Heroi.class);
        return gerenciador.createQuery(cq).getResultList();
    }

    @Override
    public Heroi carregar(Long id){
        return gerenciador.find(Heroi.class,id);
    }
}
