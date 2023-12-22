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

    /**
     * @desc Function to park a vehicle in the parking lot
     * @param parkingLots List of parking lots
     * @param vehicle Vehicle to be parked
     * @return True if the vehicle is parked successfully, false otherwise
     */
    public boolean parkVehicleForHandicapDriver(List<ParkingLot> parkingLots, Vehicle vehicle) {
        if (parkingLots == null || parkingLots.isEmpty()) {
            return false;
        }

        // Find the parking lot with the nearest available space
        ParkingLot nearestLot = findNearestParkingLot(parkingLots);

        if (nearestLot != null) {
            return nearestLot.parkVehicle(vehicle);
        }

        return false;
    }

    /**
     * @desc Function to find the parking lot with the nearest available space
     * @param parkingLots List of parking lots
     * @return ParkingLot with the nearest available space, or null if no space is available
     */
    private ParkingLot findNearestParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot nearestLot = null;
        int minCapacity = Integer.MAX_VALUE;

        for (ParkingLot lot : parkingLots) {
            if (!lot.isFull() && lot.getCapacity() < minCapacity) {
                minCapacity = lot.getCapacity();
                nearestLot = lot;
            }
        }

        return nearestLot;
    }
}
