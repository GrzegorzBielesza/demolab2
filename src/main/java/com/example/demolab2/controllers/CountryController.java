package com.example.demolab2.controllers;

import com.example.demolab2.entities.Country;
import com.example.demolab2.entities.Zadanie;
import com.example.demolab2.repositories.CountryRepository;
import com.example.demolab2.repositories.ZadanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {

    @Autowired
    public CountryRepository rep;

    @RequestMapping("/countries")
    @ResponseBody
    public String findAll() {
        StringBuilder odp = new StringBuilder();

        Iterable<Country> wszystkieRekordy = rep.findAll();

        for(Country i: rep.findAll()) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/continent/{continent}")
    @ResponseBody
    public String zadaniaKosztMniejszyNiz(@PathVariable String continent) {
        StringBuilder odp = new StringBuilder();

//korzystając z repozytorium pobieramy wszystkie zadania z bazy
        for(Country i: rep.findByContinent(continent)) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/populationBetween/{min}/{max}")
    @ResponseBody
    public String populationBetween(@PathVariable Long min, @PathVariable Long max) {
        StringBuilder odp = new StringBuilder();

        for(Country i: rep.findByPopulationBetween(min, max)) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/continent/{continent}/populationBetween/{min}/{max}")
    @ResponseBody
    public String continentAndPopulationBetween(@PathVariable String continent, @PathVariable Long min, @PathVariable Long max) {
        StringBuilder odp = new StringBuilder();

        for(Country i: rep.findByContinentAndPopulationBetween(continent, min, max)) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }
}
