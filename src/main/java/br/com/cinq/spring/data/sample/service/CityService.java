package br.com.cinq.spring.data.sample.service;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import br.com.cinq.spring.data.sample.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class CityService {

  private CityRepository cityRepository;
  private CountryRepository contryCountryRepository;

  public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
    this.cityRepository = cityRepository;
    this.contryCountryRepository = countryRepository;
  }

  public List<City> findByCountry(String countryName) throws ServiceException {
    List<Country> countries = contryCountryRepository.findByNameContainingIgnoreCase(countryName);
    if (countries.isEmpty()) {
      throw new ServiceException("Country not found: " + countryName);
    }
    return cityRepository.findByCountryIn(countries);
  }

  public City save(City city) throws ServiceException {
    try {
      city.setCountry(findCountry(city.getCountry()));
      return cityRepository.save(city);
    } catch (ConstraintViolationException ex) {
      throw ServiceException.parse(ex);
    }
  }

  private Country findCountry(Country country) throws ServiceException {
    if (country == null || country.getId() == null) {
      throw new ServiceException("Country id must not be null");
    }

    return contryCountryRepository
        .findById(country.getId())
        .orElseThrow(() -> new ServiceException("Country not found"));
  }
}
