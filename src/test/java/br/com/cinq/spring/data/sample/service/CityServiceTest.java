package br.com.cinq.spring.data.sample.service;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.entity.City;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CityServiceTest {

  @Autowired private CityService cityService;

  @Test
  public void should_return_cities_by_country_name() throws ServiceException {
    List<City> cities = cityService.findByCountry("Uni");
    assertThat("Cities should not be null", cities.size(), Matchers.greaterThan(0));
  }

  @Test
  public void should_return_not_save_city_without_country() throws ServiceException {
    try {
      City city = new City();
      city.setName("Some City");
      cityService.save(city);
      fail("Should've not saved city without country");
    } catch (ServiceException ex) {
      assertThat(ex.getMessage(), CoreMatchers.equalTo("Country id must not be null"));
    }
  }
}
