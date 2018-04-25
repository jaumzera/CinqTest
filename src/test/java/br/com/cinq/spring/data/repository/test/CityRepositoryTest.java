package br.com.cinq.spring.data.repository.test;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("unit")
public class CityRepositoryTest {

  @Autowired private CityRepository dao;

  @Before
  public void beforeTests() {
    assertThat("Repository should not be null", dao, notNullValue());
  }

  // NOTE 1: I changed the name from 'testQueryCityByCountry' to 'testQueryCityByCountry'
  // NOTE 2: I changed assertions for Hamcrest ones, because I think it's clearer
  @Test
  public void testQueryCityByCountry() {
    assertThat("Repository should not be empty", dao.count(), greaterThan(0L));

    Country country = new Country();
    country.setId(3); // Should be France

    List<City> list = dao.findByCountry(country);
    assertThat("findByCountry should return 2", list.size(), equalTo(2));
  }
}
