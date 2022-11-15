package com.example.demolab2.repositories;

import com.example.demolab2.entities.Zadanie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZadanieRepository extends CrudRepository<Zadanie, Long> {

    List<Zadanie> findByWykonane(Boolean wykonane);

    List<Zadanie> findByKosztLessThan(double koszt);

    List<Zadanie> findByKosztBetween(double kosztFrom, double kosztTo);
}
