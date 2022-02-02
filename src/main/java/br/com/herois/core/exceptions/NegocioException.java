package br.com.herois.core.exceptions;

public class NegocioException extends BaseException{
    private static final long serialVersionUID = 1L;

    public NegocioException(EnumeradoDeErro erro) {
        this(erro,null);
    }

    public NegocioException(EnumeradoDeErro erro, Throwable causa) {
        super(erro.getMenssagem(),erro.getStatus(),causa);
    }

}
