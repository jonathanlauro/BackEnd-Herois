package br.com.herois.core.repository;

import br.com.herois.core.entity.Heroi;
import br.com.herois.core.exceptions.NegocioException;

import java.util.List;

public interface RepositorioDeHeroi {

    Heroi cadastrar(Heroi heroi);

    Heroi atualizar(Heroi heroi);

    Heroi deletar(Long id) throws NegocioException;

    List<Heroi> findAll();

    Heroi carregar(Long id);
}
