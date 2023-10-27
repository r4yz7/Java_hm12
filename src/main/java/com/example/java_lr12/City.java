package com.example.java_lr12;

public class City {
    int id;
    String cityName;
    String description;
    boolean isCapital;
    String country;

    public City(int id, String cityName, String description, boolean isCapital, String country) {
        this.id = id;
        this.cityName = cityName;
        this.description = description;
        this.isCapital = isCapital;
        this.country = country;
    }
    public City(){}
    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public String getCountry() {
        return country;
    }
}
