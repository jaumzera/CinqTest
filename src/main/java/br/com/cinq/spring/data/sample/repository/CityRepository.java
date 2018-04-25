package br.com.cinq.spring.data.sample.repository;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

  List<City> findByCountry(Country country);

  @Query("SELECT city FROM City city JOIN FETCH city.country WHERE city.country IN (:countries)")
  List<City> findByCountryIn(@Param("countries") List<Country> countries);
}
