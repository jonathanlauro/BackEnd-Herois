package br.com.herois.core.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
       containerResponseContext.getHeaders().add("Acess-Control-Allow-Origin", "*");
       containerResponseContext.getHeaders().add("Acess-Control-Allow-Credencials", "true");
       containerResponseContext.getHeaders().add("Acess-Control-Allow-Headers", "origin, content-type, accept, authorization");
       containerResponseContext.getHeaders().add("Acess-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
