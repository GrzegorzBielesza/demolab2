package com.example.demolab2.repositories;

import com.example.demolab2.entities.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findByContinent(String continent);

    List<Country> findByPopulationBetween(Long from, Long to);

    List<Country> findByContinentAndPopulationBetween(String continent, Long from, Long to);


}
