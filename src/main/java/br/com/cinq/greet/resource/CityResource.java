package br.com.cinq.greet.resource;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.service.CityService;
import br.com.cinq.spring.data.sample.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.List;

@Path("cities")
public class CityResource {

  @Autowired private CityService cityService;

  @GET
  @Produces("application/json")
  public List<City> getCities(@QueryParam("country") String countryName) throws ServiceException {
    if (countryName != null) {
      return cityService.findByCountry(countryName);
    } else {
      return cityService.findAll();
    }
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public City saveCity(City city) throws ServiceException {
    return cityService.save(city);
  }
}
