package com.bridgelabz.parkinglot;

/**
 * @desc This class represents a parking attendant
 */
public class ParkingAttendant {
    /**
     * @desc Function to park a vehicle in the parking lot
     * @param parkingLot Parking lot where the vehicle is to be parked
     * @param vehicle Vehicle to be parked
     * @return True if the vehicle is parked successfully, false otherwise
     */
    public boolean parkVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        if (parkingLot.isFull()) {
            return false;
        }
        return parkingLot.parkVehicle(vehicle);
    }
}
