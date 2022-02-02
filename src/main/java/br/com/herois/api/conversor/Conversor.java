package br.com.herois.api.conversor;

import java.util.List;

public interface Conversor <E,M>{

    E toEntidade(M modelo);

    M toModelo(E entidade);

    List<E> toListEntidade(List<M> listaModelo);

    List<M> toListaModelo(List<E> listaEntidade);
}
