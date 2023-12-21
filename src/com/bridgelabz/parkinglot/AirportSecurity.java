package com.bridgelabz.parkinglot;

/**
 * @desc This class extends the ParkingLotObservers interface and represents Airport Security
 */
public class AirportSecurity implements ParkingLotObservers {
    private boolean isFullCapacity;

    /**
     * @desc function to set capacity as full
     */
    @Override
    public void setCapacityFull() {
        isFullCapacity = true;
    }

    /**
     * @desc function to check if parking lot is full
     * @return True if full else false
     */
    @Override
    public boolean isCapacityFull() {
        return this.isFullCapacity;
    }
}