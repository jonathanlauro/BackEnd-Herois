package br.com.herois.api.model;

import java.io.Serializable;

public class HeroiModelo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Integer idade;
    private Integer forca;

    public HeroiModelo() {
        this(null,null,null,null);
    }

    public HeroiModelo(Long id, String nome, Integer idade, Integer forca) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.forca = forca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    @Override
    public String toString() {
        return "HeroiModelo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", forca=" + forca +
                '}';
    }
}
