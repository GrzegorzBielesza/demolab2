package com.example.demolab2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
@Getter
@Setter
public class Zadanie{
    @GeneratedValue
    @Id
    private Long id;
    @Column
    private String nazwa;
    @Column
    @Lob
    private String opis;
    @Column
    private Double koszt;
    @Column
    private Boolean wykonane=false;
    public Zadanie() {
        this.koszt = 2000.0;
        this.nazwa="Zadanie";
        this.opis="Zadanie do wykonania";
    }
    //nadpisana metoda toString
    @Override
    public String toString() {
        return "Encja Zadanie{ id=" + id + ", " + nazwa + ", " +
                opis + ", koszt=" + koszt + ", wykonane=" + wykonane +
                "}";
    }
//dodaj metody get i set
}
