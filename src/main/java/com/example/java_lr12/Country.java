package com.example.java_lr12;

public class Country {
    int id;
    String countryName;
    int countPeople;

    public Country(int id, String countryName, int countPeople) {
        this.id = id;
        this.countryName = countryName;
        this.countPeople = countPeople;
    }

    public int getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getCountPeople() {
        return countPeople;
    }
}
