package br.com.cinq.spring.data.sample.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Register Jersey modules
 *
 * @author Adriano Kretschmer
 */
@Configuration
@ApplicationPath("rest")
public class Config extends ResourceConfig {

  public Config() {
    packages("br.com.cinq.greet.resource");
    property(ServletProperties.FILTER_FORWARD_ON_404, true);
  }
}
