package br.com.herois.api.conversor;

import br.com.herois.api.model.HeroiModelo;
import br.com.herois.core.entity.Heroi;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ConversorDeHeroi implements Conversor<Heroi, HeroiModelo>{

    @Override
    public Heroi toEntidade(HeroiModelo modelo) {
        return new Heroi(
                modelo.getId(),
                modelo.getNome(),
                modelo.getIdade(),
                modelo.getForca()
                );
    }

    @Override
    public HeroiModelo toModelo(Heroi entidade) {
        return new HeroiModelo(
                entidade.getId(),
                entidade.getNome(),
                entidade.getIdade(),
                entidade.getForca()
        );
    }

    @Override
    public List<Heroi> toListEntidade(List<HeroiModelo> listaModelo) {
        List<Heroi> herois = new ArrayList<>();

        for (HeroiModelo modelo: listaModelo) {
            herois.add(new Heroi(
                    modelo.getId(),
                    modelo.getNome(),
                    modelo.getIdade(),
                    modelo.getForca()
            ));
        }
        return herois;
    }

    @Override
    public List<HeroiModelo> toListaModelo(List<Heroi> listaEntidade) {
        List<HeroiModelo> herois = new ArrayList<>();
        listaEntidade.forEach(item -> herois.add(new HeroiModelo(
                item.getId(),
                item.getNome(),
                item.getIdade(),
                item.getForca()
        )));
        return herois;
    }
}
