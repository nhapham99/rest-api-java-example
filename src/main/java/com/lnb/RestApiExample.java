package com.lnb;
import com.lnb.models.Weather;
import com.lnb.repositories.WeatherRepository;

public class RestApiExample {
    public static void main(String[] args) {
        getWeather();
    }

    private static void getWeather() {
        WeatherRepository weatherRepository = new WeatherRepository();
        Weather weather = weatherRepository.getWeather("London");
        if (weather != null) {
            System.out.println(weather);
        } else {
            System.out.println("ERROR: get weather error");
        }
    }
}