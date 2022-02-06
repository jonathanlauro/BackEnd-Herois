package br.com.herois.core.service;

import br.com.herois.core.entity.Heroi;
import br.com.herois.core.exceptions.NegocioException;

import java.util.List;

public interface HeroiService {

    Heroi cadastrar(Heroi heroi) throws NegocioException;

    Heroi atualizar(Heroi heroi) throws NegocioException;

    Heroi deletar(Long id) throws NegocioException;

    List<Heroi> listar();
}
