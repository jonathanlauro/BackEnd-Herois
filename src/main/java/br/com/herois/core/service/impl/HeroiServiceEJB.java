package br.com.herois.core.service.impl;

import br.com.herois.core.entity.Heroi;
import br.com.herois.core.exceptions.NegocioException;
import br.com.herois.core.repository.RepositorioDeHeroi;
import br.com.herois.core.service.HeroiService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

import static br.com.herois.core.exceptions.erros.ErroDeHeroi.*;
import static java.util.Objects.isNull;

@Stateless
@Local(HeroiService.class)
public class HeroiServiceEJB implements HeroiService {

    @Inject
    private RepositorioDeHeroi repositorio;

    @Override
    public Heroi cadastrar(Heroi heroi) throws NegocioException {
        validaheroi(heroi);
        return repositorio.cadastrar(heroi);
    }

    @Override
    public Heroi atualizar(Heroi heroi) {
        return null;
    }

    @Override
    public Heroi deletar(Long id) throws NegocioException {
        return repositorio.deletar(id);
    }

    @Override
    public List<Heroi> listar() {
        return repositorio.findAll();
    }

    private void validaheroi(Heroi heroi) throws NegocioException {
        if(isNull(heroi.getNome()) || heroi.getNome().isEmpty()){
            throw new NegocioException(NOME_HEROI);
        }
        if(isNull(heroi.getIdade())){
            throw new NegocioException(IDADE_HEROI);
        }
        if(isNull(heroi.getForca())){
            throw new NegocioException(FORCA_HEROI);
        }
    }
}
