package com.example.demolab2.controllers;

import com.example.demolab2.entities.Zadanie;
import com.example.demolab2.repositories.ZadanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @Autowired
    public ZadanieRepository rep;

    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello Spring Boot from mainPage() method!";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hello Spring Boot from pageTwo() method!";
    }

    @RequestMapping("/uzupelnij")
    @ResponseBody
    public String uzupelnijDane() {

        Zadanie z;
        double k=1000;
        boolean wyk=false;
        for (int i=1;i<=10;i++) {
            z = new Zadanie();
            z.setNazwa("zadanie " + i);
            z.setOpis("Opis czynnosci do wykonania w zadaniu " + i);
            z.setKoszt(k);
            z.setWykonane(wyk);
            wyk = !wyk;
            k += 200.50;
            rep.save(z);
        }
        return "redirect:/listaZadan";
    }

    @RequestMapping("/listaZadan")
    @ResponseBody
    public String listaZadan() {
        StringBuilder odp = new StringBuilder();

//korzystając z repozytorium pobieramy wszystkie zadania z bazy
        for(Zadanie i: rep.findAll()) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        rep.deleteById(id);
        return "redirect:/viewAll";
    }

    @RequestMapping("/zadaniaWykonane")
    @ResponseBody
    public String zadaniaWykonane() {
        StringBuilder odp = new StringBuilder();

//korzystając z repozytorium pobieramy wszystkie zadania z bazy
        for(Zadanie i: rep.findByWykonane(true)) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/zadaniaKosztMniejszyNiz/{koszt}")
    @ResponseBody
    public String zadaniaKosztMniejszyNiz(@PathVariable double koszt) {
        StringBuilder odp = new StringBuilder();

//korzystając z repozytorium pobieramy wszystkie zadania z bazy
        for(Zadanie i: rep.findByKosztLessThan(koszt)) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }

    @RequestMapping("/zadaniaKosztPomiedzy/{min}/{max}")
    @ResponseBody
    public String zadaniaKosztPomiędzy(@PathVariable double min, @PathVariable double max) {
        StringBuilder odp = new StringBuilder();

//korzystając z repozytorium pobieramy wszystkie zadania z bazy
        for(Zadanie i: rep.findByKosztBetween(min, max)) {
            odp.append(i).append("<br>");
        }
        return odp.toString();
    }
}
