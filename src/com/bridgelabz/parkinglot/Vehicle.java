package com.bridgelabz.parkinglot;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc This class represents a vehicle
 */
public class Vehicle {
    private String numberPlate;
    private String make;
    private String color;
    private long timeParked;

    /**
     * @desc Constructor to initialize vehicle details
     * @param numberPlate Vehicle Number plate
     * @param make Vehicle Make
     * @param color Vehicle color
     */
    public Vehicle(String numberPlate, String make, String color) {
        this.numberPlate = numberPlate;
        this.make = make;
        this.color = color;
        this.timeParked = System.currentTimeMillis();
    }

    /**
     * @desc Getter function for number plate
     * @return Vehicle Number plate
     */
    public String getNumberPlate() {
        return numberPlate;
    }

    /**
     * @desc Getter function for make of vehicle
     * @return Vehicle Make
     */
    public String getMake() {
        return make;
    }

    /**
     * @desc Getter function for color of vehicle
     * @return Vehicle color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return Vehicle parking time
     * @desc Getter function for parking time
     */
    public String getTimeParked() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultDate = new Date(timeParked);
        return sdf.format(resultDate);
    }
}
