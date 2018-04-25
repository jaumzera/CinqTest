package br.com.cinq.spring.data.sample.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/** Greeting Service. */
@ComponentScan("br.com.cinq.spring.data.sample")
@EntityScan("br.com.cinq.spring.data.sample.entity")
@EnableJpaRepositories("br.com.cinq.spring.data.sample.repository")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

  public static void main(String[] args) {
    new Application().configure(new SpringApplicationBuilder(Application.class)).run(args);
  }
}
