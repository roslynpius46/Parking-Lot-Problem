package com.bridgelabz.parkinglot;

import java.util.List;

/**
 * @desc This class represents a parking attendant
 */
public class ParkingAttendant {

    private int lastLotIndex = 0;

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

    /**
     * @desc Function to park a vehicle in the parking lot
     * @param parkingLots List of parking lots where the vehicle can be parked
     * @param vehicle Vehicle to be parked
     * @return True if the vehicle is parked successfully, false otherwise
     */
    public boolean refactoredParkVehicle(List<ParkingLot> parkingLots, Vehicle vehicle) {
        for (int i = 0; i < parkingLots.size(); i++) {
            int lotIndex = (lastLotIndex + i) % parkingLots.size();
            ParkingLot parkingLot = parkingLots.get(lotIndex);

            if (!parkingLot.isFull()) {
                lastLotIndex = lotIndex;
                return parkingLot.parkVehicle(vehicle);
            }
        }

        return false;
    }
}
