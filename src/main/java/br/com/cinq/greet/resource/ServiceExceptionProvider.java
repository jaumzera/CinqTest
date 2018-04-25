package br.com.cinq.greet.resource;

import br.com.cinq.spring.data.sample.service.ServiceException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceExceptionProvider implements ExceptionMapper<ServiceException> {

  @Override
  public Response toResponse(ServiceException ex) {
    return Response.status(404).entity(ex.getParsedMessages()).type("application/json").build();
  }
}
