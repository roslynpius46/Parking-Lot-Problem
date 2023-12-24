package com.bridgelabz.parkinglot;

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
}
