package br.com.herois.core.service;

import br.com.herois.core.entity.Heroi;
import br.com.herois.core.exceptions.NegocioException;
import br.com.herois.core.repository.impl.RepositorioDeHeroiEJB;
import br.com.herois.core.service.impl.HeroiServiceEJB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HeroiServiceEJBTest {

    @InjectMocks
    HeroiServiceEJB service;

    @Mock
    RepositorioDeHeroiEJB repository;

    @Test(expected = NegocioException.class)
    public void naoDeveAdicionarUmHeroiComNomeNulo() throws NegocioException{
        service.cadastrar(new Heroi());
    }
    @Test(expected = NegocioException.class)
    public void naoDeveAdicionarHeroiComNomeVazio() throws NegocioException{
        Heroi heroi = new Heroi();
        heroi.setNome("");
        service.cadastrar(heroi);
    }
    @Test(expected = NegocioException.class)
    public void naoDeveAdicionarHeroiComIdadeNulo() throws NegocioException{
        Heroi heroi = new Heroi();
        heroi.setNome("teste");
        service.cadastrar(heroi);
    }
    @Test(expected = NegocioException.class)
    public void naoDeveAdicionarHeroiComForcaNulo() throws NegocioException{
        Heroi heroi = new Heroi();
        heroi.setNome("Teste");
        heroi.setIdade(22);
        service.cadastrar(heroi);
    }
    @Test
    public void deveAdicionarUmHeroi() throws NegocioException{
        when(repository.cadastrar(any(Heroi.class))).thenReturn(new Heroi(1L,"teste",30,30));
        Assert.assertNotNull(service.cadastrar(new Heroi(1L,"teste",30,30)));
    }
}
