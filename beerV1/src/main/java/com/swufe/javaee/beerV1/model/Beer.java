package com.swufe.javaee.beerV1.model;

public class Beer {
    private String name;
    private String band;
    private int year_of_birth;

    public Beer() {

    }

    public Beer(String name, String band, int year_of_birth) {
        this.name = name;
        this.band = band;
        this.year_of_birth = year_of_birth;
    }

    public String toString(){
        return (name+"<br>"+"brand is:"+band+"<br>"+" birth year is:"+year_of_birth);
    }
}
