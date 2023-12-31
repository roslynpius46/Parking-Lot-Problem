package com.bridgelabz.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc This class represents the Police Department
 */
public class PoliceDepartment {

    /**
     * @desc Function to get the location of all parked white cars in a parking lot
     * @param parkingLot The parking lot to search for white cars
     * @return List of locations (indices) of parked white cars
     */
    public List<Integer> getLocationsOfParkedWhiteCars(ParkingLot parkingLot) {
        return parkingLot.findLocationsOfParkedWhiteCars();
    }

    /**
     * @desc Function to get details of blue toyota cars
     * @param parkingLot The parking lot to search for blue toyota cars
     * @return Details of parked blue toyota cars
     */
    public List<VehicleDetails> getDetailsOfParkedBlueToyotaCars(ParkingLot parkingLot,ParkingAttendant parkingAttendant) {
        List<VehicleDetails> detailsList = new ArrayList<>();
        List<Vehicle> parkedVehicles = parkingLot.getParkedVehicles();

        for (int i = 0; i < parkedVehicles.size(); i++) {
            Vehicle vehicle = parkedVehicles.get(i);

            if (isBlueToyota(vehicle)) {

                VehicleDetails details = new VehicleDetails(i, vehicle.getNumberPlate(), vehicle.getMake(),
                        vehicle.getColor(), parkingAttendant.getName());
                detailsList.add(details);
            }
        }

        return detailsList;
    }

    /**
     * @desc Function to check if vehicle is a blue toyota
     * @param vehicle Object representing vehicle
     * @return True if the vehicle is a blue toyota else false
     */
    private boolean isBlueToyota(Vehicle vehicle) {
        return "Toyota".equals(vehicle.getMake()) && "Blue".equals(vehicle.getColor());
    }

    /**
     * @desc Get details of all parked BMW cars
     * @param parkingLot The parking lot to search
     * @return List of details of parked BMW cars
     */
    public List<VehicleDetails> getParkedBMWCars(ParkingLot parkingLot,ParkingAttendant parkingAttendant) {
        List<VehicleDetails> bmwCars = new ArrayList<>();
        List<Vehicle> parkedVehicles = parkingLot.getParkedVehicles();

        for (int i = 0; i < parkedVehicles.size(); i++) {
            Vehicle vehicle = parkedVehicles.get(i);

            if ("BMW".equals(vehicle.getMake()) ) {

                VehicleDetails details = new VehicleDetails(i, vehicle.getNumberPlate(), vehicle.getMake(),
                        vehicle.getColor(), parkingAttendant.getName());
                bmwCars.add(details);
            }
        }


        return bmwCars;
    }

    /**
     * @desc Get details of all cars parked in the last 30 minutes
     * @param parkingLot The parking lot to search
     * @return List of details of cars parked in the last 30 minutes
     */
    public List<VehicleDetails> getCarsParkedInLast30Minutes(ParkingLot parkingLot,ParkingAttendant parkingAttendant) {
        List<VehicleDetails> recentCars = new ArrayList<>();

        long currentTime = System.currentTimeMillis();
        long thirtyMinutesInMillis = 30 * 60 * 1000; // 30 minutes in milliseconds

        List<Vehicle> parkedVehicles = parkingLot.getParkedVehicles();

        for (int i = 0; i < parkedVehicles.size(); i++) {
            Vehicle vehicle = parkedVehicles.get(i);
            long parkingTime = vehicle.getTimeParked();

            if (currentTime - parkingTime <= thirtyMinutesInMillis) {

                VehicleDetails details = new VehicleDetails(i, vehicle.getNumberPlate(), vehicle.getMake(),
                        vehicle.getColor(), parkingAttendant.getName());
                recentCars.add(details);
            }
        }

        return recentCars;
    }

    /**
     * @desc Get all parked car details
     * @param parkingLot Parking lot required
     * @param parkingAttendant Parking attendant
     * @return details of all the cars parked in that parking lot
     */
    public List<VehicleDetails> getAllParkedCars(ParkingLot parkingLot, ParkingAttendant parkingAttendant) {
        List<VehicleDetails> allParkedCars = new ArrayList<>();

        List<Vehicle> parkedVehicles = parkingLot.getParkedVehicles();

        for (int i = 0; i < parkedVehicles.size(); i++) {
            Vehicle vehicle = parkedVehicles.get(i);

            VehicleDetails details = new VehicleDetails(i, vehicle.getNumberPlate(), vehicle.getMake(),
                    vehicle.getColor(), parkingAttendant.getName());
            allParkedCars.add(details);
        }

        return allParkedCars;
        }

    }
