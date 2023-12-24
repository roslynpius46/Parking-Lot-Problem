package com.bridgelabz.parkinglot;

import java.util.Objects;

/**
 * @desc This class represents details of a parked vehicle
 */
public class VehicleDetails {
    private final int location;
    private final String numberPlate;
    private final String make;
    private final String color;
    private final String parkingAttendantName;

    /**
     * @desc Constructor to initialize vehicle details object
     * @param location Parked location
     * @param numberPlate Vehicle number plate
     * @param make Vehicle make
     * @param color Vehicle color
     * @param parkingAttendantName Parking attendant name
     */
    public VehicleDetails(int location, String numberPlate, String make, String color, String parkingAttendantName) {
        this.location = location;
        this.numberPlate = numberPlate;
        this.make = make;
        this.color = color;
        this.parkingAttendantName = parkingAttendantName;
    }

    /**
     * @desc Overrides the equals method to compare the content of VehicleDetails objects
     * @param o The object to compare with this VehicleDetails object.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDetails that = (VehicleDetails) o;
        return location == that.location &&
                Objects.equals(numberPlate, that.numberPlate) &&
                Objects.equals(make, that.make) &&
                Objects.equals(color, that.color) &&
                Objects.equals(parkingAttendantName, that.parkingAttendantName);
    }

    /**
     * @desc Generates a hash code for the VehicleDetails object based on its fields.
     * @return The hash code for the VehicleDetails object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(location, numberPlate, make, color, parkingAttendantName);
    }
}
