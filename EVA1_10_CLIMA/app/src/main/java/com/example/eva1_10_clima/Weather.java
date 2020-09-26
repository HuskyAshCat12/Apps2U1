package com.example.eva1_10_clima;

public class Weather {
    /*Nombre de la ciudad - String
     * Temperatura - int
     * Descripción del clima - String
     * Imagen* - int*/

    private String city, climate;
    private int temp;
    private int image;

    public Weather(String city, int temp, String climate, int image) {
        this.city = "";
        this.temp = 0;
        this.climate = "";
        this.image = 0;
    }
    public Weather(){

    }

    public String getCity() {
        return city;
    }

    public String getClimate() {
        return climate;
    }

    public int getTemp() {
        return temp;
    }

    public int getImage() {
        return image;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
