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
}
