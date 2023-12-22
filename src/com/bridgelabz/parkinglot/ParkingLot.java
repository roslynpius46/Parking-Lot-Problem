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
        vehicle.setTimeParked(System.currentTimeMillis());
        parkedVehicles.add(vehicle);
        return true;
    }

    /**
     * @desc Get the list of parked vehicles
     * @return List of parked vehicles
     */
    public List<Vehicle> getParkedVehicles()
    {
        return new ArrayList<>(parkedVehicles);
    }

    /**
     * @desc Function to unpark vehicle
     * @param vehicle Vehicle to be unparked
     * @return True if unparking successful else false
     */
    public boolean unparkVehicle(Vehicle vehicle)
    {
        notifyObserversAvailable();
        return parkedVehicles.remove(vehicle);
    }

    /**
     * @desc Registering new observer
     * @param parkingObservers Observer to be added
     */
    public void register(ParkingLotObservers parkingObservers)
    {
        observersList.add(parkingObservers);
    }

    /**
     * @desc Function to notify all observers if parking lot is full
     */
    private void notifyObserversFull() {
        for (ParkingLotObservers observer : observersList) {
            observer.setCapacityFull();
        }
    }

    /**
     * @desc Checking if parking lot is full
     * @return True if full else false
     */
    public boolean isFull() {
        boolean isFull = parkedVehicles.size() == capacity;
        if (isFull) {
            notifyObserversFull();
        }
        else {
            notifyObserversAvailable();
        }
        return isFull;
    }

    /**
     * @desc Function to notify all observers if parking space is available
     */
    private void notifyObserversAvailable() {
        for (ParkingLotObservers observer : observersList) {
            observer.setCapacityAvailable();
        }
    }

    /**
     * @desc Function to find a parked vehicle by its number plate
     * @param numberPlate Number plate of the vehicle to find
     * @return The found vehicle or null if not found
     */
    public int findVehicleByNumberPlate(String numberPlate) {
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate)) {
                return parkedVehicles.indexOf(vehicle);
            }
        }
        return -1;
    }

    /**
     * @desc Function to get parking duration
     * @param numberPlate Number plate of the vehicle
     * @return time for which car was parked
     */
    public long getParkingDuration(String numberPlate) {
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate)) {
                long currentTime = System.currentTimeMillis();
                return currentTime - vehicle.getTimeParked();
            }
        }
        return -1;
    }

}
