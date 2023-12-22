package com.bridgelabz.parkinglot;

public interface ParkingLotObservers {
    void setCapacityFull();
    void setCapacityAvailable();
    boolean isCapacityFull();
}