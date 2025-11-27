package com.example.lab10;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;
    private int temperature;
    private int humidity;
    private int pressure;
    private Date date;

    public Measurement() {
    }
    public Measurement(Location location, int temperature, int humidity, int pressure, Date date) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public int getPressure() {
        return pressure;
    }
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
