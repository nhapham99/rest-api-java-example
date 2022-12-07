package com.lnb.models;

import java.util.Map;

public class Weather {
    private Location location;

    private double temperature;

    private double windSpeed;

    private double windDegree;

    private String windDirection;

    private String lastUpdate;

    public Weather(Location location, double temperature, double windSpeed, double windDegree, String windDirection, String lastUpdate) {
        this.location = location;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.windDirection = windDirection;
        this.lastUpdate = lastUpdate;
    }

    @SuppressWarnings("unchecked")
    public Weather(Map<String, Object> map) {
        this.location = new Location((Map<String, Object>) map.get("location"));
        Map<String, Object> data = (Map<String, Object>) map.get("current");
        this.temperature = (double) data.get("temp_c");
        this.windSpeed = (double) data.get("wind_kph");
        this.windDegree = (double) data.get("wind_degree");
        this.windDirection = (String) data.get("wind_dir");
        this.lastUpdate = (String) data.get("last_updated");
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(double windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "location=" + location.toString() +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", windDegree=" + windDegree +
                ", windDirection='" + windDirection + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}
