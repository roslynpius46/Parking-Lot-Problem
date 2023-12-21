package com.bridgelabz.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc This class represents the Parking Lot
 */
public class ParkingLot {
    private final int capacity;
    private List<Vehicle> parkedVehicles;
    List<ParkingLotObservers> observersList;

    /**
     * @desc Constructor to initialize the capacity and total list of parked vehicles
     * @param capacity Total capacity of the parking lot
     */
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedVehicles = new ArrayList<>();
        this.observersList = new ArrayList<>();
    }

    /**
     * @desc Function to park vehicle
     * @param vehicle Vehicle to be parked
     */
    public boolean parkVehicle(Vehicle vehicle) {
        if(isFull())
        {
            return false;
        }
        String numberPlate = vehicle.getNumberPlate();
        parkedVehicles.add(vehicle);
        return true;
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

    /**
     * @desc Registering new observer
     * @param parkingObservers Observer to be added
     */
    public void register(ParkingLotObservers parkingObservers) {
        observersList.add(parkingObservers);
    }

    /**
     * @desc Function to notify all observers if parking lot is full
     */
    private void notifyObservers() {
        for (ParkingLotObservers observer : observersList) {
            observer.setCapacityFull();
        }
    }

    /**
     * @desc Checking if parking lot is full
     * @return True if full else false
     */
    public boolean isFull() {
        boolean isFull = parkedVehicles.size() >= capacity;
        if (isFull) {
            notifyObservers();
        }
        return isFull;
    }

}
