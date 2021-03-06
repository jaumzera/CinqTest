package br.com.cinq.spring.data.sample.service;

import lombok.Getter;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.ext.Provider;
import java.util.HashSet;
import java.util.Set;

@Provider
public class ServiceException extends Exception {

  @Getter private Set<String> parsedMessages = new HashSet<>();

  public ServiceException(Throwable cause) {
    super(cause);
  }

  public ServiceException(String message) {
    super(message);
    addMessage(message);
  }

  public static ServiceException parse(ConstraintViolationException ex) {
    ServiceException instance = new ServiceException(ex);
    ex.getConstraintViolations().stream().forEach(cv -> instance.addMessage(cv.getMessage()));
    return instance;
  }

  public ServiceException addMessage(String text) {
    parsedMessages.add(text);
    return this;
  }
}
