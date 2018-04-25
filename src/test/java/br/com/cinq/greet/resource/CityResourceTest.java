package br.com.cinq.greet.resource;

import br.com.cinq.spring.data.sample.application.Application;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = Application.class
)
public class CityResourceTest {

  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void test_GET_cities() {
    ResponseEntity<String> entity =
        this.restTemplate.getForEntity("/rest/cities?country=uni", String.class);

    assertThat("It should've returned OK", entity.getStatusCode(), equalTo(HttpStatus.OK));

    String responseBody = entity.getBody();

    assertThat(
        "It should countain 'New York'", responseBody, CoreMatchers.containsString("New York"));

    assertThat(
        "It should countain 'Los Angeles'",
        responseBody,
        CoreMatchers.containsString("Los Angeles"));

    assertThat(
        "It should countain 'Atlanta'", responseBody, CoreMatchers.containsString("Atlanta"));
  }
}
