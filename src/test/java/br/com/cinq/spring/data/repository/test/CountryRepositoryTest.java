package br.com.cinq.spring.data.repository.test;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CountryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.assertThat;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("unit")
public class CountryRepositoryTest {

  @Autowired private CountryRepository dao;

  @Before
  public void beforeTests() {
    assertThat("Repository should not be null", dao, notNullValue());
  }

  @Test
  public void testGelAllCountries() {
    long count = dao.count();
    assertThat("Repository should not be empty", count, greaterThan(0L));
    List<Country> countries = dao.findAll();
    assertThat("findAll should return all", (int) count, equalTo(countries.size()));
  }

  @Test
  public void testFindOneCountry() {
    assertThat(
        "findByNameContainingIgnoreCase should return 1",
        dao.findByNameContainingIgnoreCase("Fra").size(),
        equalTo(1));
  }
}
