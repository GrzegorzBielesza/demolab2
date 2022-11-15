package com.example.demolab2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Country {

    @Id
    private String code;
    private String name;
    private String continent;
    private long population;
    private double surfaceArea;


    public Country() {}

    @Override
    public String toString() {
        return "Encja Country{ code=" + code + ", " + name + ", " +
                "continent=" + continent + ", " +
                "population=" + population + ", " +
                "surfacearea=" + surfaceArea + "}";
    }
}
