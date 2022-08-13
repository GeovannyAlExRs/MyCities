package com.example.mycities.model;

public class City {
    private int id_city;
    private String ci_name;
    private String ci_description;
    private Float ci_photo;
    private Float ci_temperature;

    public City() {
    }

    public City(int id_city, String ci_name, String ci_description, Float ci_photo, Float ci_temperature) {
        this.id_city = id_city;
        this.ci_name = ci_name;
        this.ci_description = ci_description;
        this.ci_photo = ci_photo;
        this.ci_temperature = ci_temperature;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getCi_name() {
        return ci_name;
    }

    public void setCi_name(String ci_name) {
        this.ci_name = ci_name;
    }

    public String getCi_description() {
        return ci_description;
    }

    public void setCi_description(String ci_description) {
        this.ci_description = ci_description;
    }

    public Float getCi_photo() {
        return ci_photo;
    }

    public void setCi_photo(Float ci_photo) {
        this.ci_photo = ci_photo;
    }

    public Float getCi_temperature() {
        return ci_temperature;
    }

    public void setCi_temperature(Float ci_temperature) {
        this.ci_temperature = ci_temperature;
    }

    @Override
    public String toString() {
        return "City{" + "id_city=" + id_city + ", ci_name='" + ci_name + '\'' +
                ", ci_description='" + ci_description + '\'' + ", ci_photo=" + ci_photo +
                ", ci_temperature=" + ci_temperature + '}';
    }
}