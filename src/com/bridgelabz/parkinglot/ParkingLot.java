package com.bridgelabz.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc This class represents the Parking Lot
 */
public class ParkingLot {
    private final int capacity;
    private List<Vehicle> parkedVehicles;

    /**
     * @desc Constructor to initialize the capacity and total list of parked vehicles
     * @param capacity Total capacity of the parking lot
     */
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedVehicles = new ArrayList<>();
    }

    /**
     * @desc Function to park vehicle
     * @param vehicle Vehicle to be parked
     */
    public void parkVehicle(Vehicle vehicle) {
        String numberPlate = vehicle.getNumberPlate();
        parkedVehicles.add(vehicle);
    }

    /**
     * @desc Get the list of parked vehicles
     * @return List of parked vehicles
     */
    public List<Vehicle> getParkedVehicles() {
        return new ArrayList<>(parkedVehicles);
    }

    /**
     * @desc Function to unpark vehicle
     * @param vehicle Vehicle to be unparked
     * @return True if unparking successful else false
     */
    public boolean unparkVehicle(Vehicle vehicle) {
        return parkedVehicles.remove(vehicle);
    }
}
