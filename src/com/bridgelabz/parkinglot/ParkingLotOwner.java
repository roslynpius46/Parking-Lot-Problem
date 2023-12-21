package com.bridgelabz.parkinglot;

public class ParkingLotOwner implements ParkingLotObservers {
    private boolean isFullCapacity;


    @Override
    public void setCapacityFull() {
        isFullCapacity = true;
    }

    @Override
    public boolean isCapacityFull() {
        return this.isFullCapacity;
    }
}