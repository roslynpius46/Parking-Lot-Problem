package com.bridgelabz.parkinglot;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Implementation of Parking Lot Problem");

        ParkingLot parkingLot = new ParkingLot(2);

        Vehicle car1 = new Vehicle("ABC123", "Toyota", "Blue");
        Vehicle car2 = new Vehicle("XYZ789", "Honda", "Red");

        // USE CASE 1: Park vehicles in the Parking Lot
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);

        System.out.println("Parked Vehicles:");
        for (Vehicle vehicle : parkingLot.getParkedVehicles()) {
            System.out.println("Number Plate: " + vehicle.getNumberPlate());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Time Parked: " + vehicle.getTimeParked());
            System.out.println();
        }

        // USE CASE 2: Unpark a vehicle
        System.out.println("Unparking Vehicle with Number Plate: " + car1.getNumberPlate());
        boolean unparked = parkingLot.unparkVehicle(car1);

        if (unparked) {
            System.out.println("Vehicle unparked successfully.");
        } else {
            System.out.println("Failed to unpark the vehicle. It may not be in the parking lot.");
        }

        // Print updated information about parked vehicles
        System.out.println("\nUpdated Parked Vehicles:");
        for (Vehicle vehicle : parkingLot.getParkedVehicles()) {
            System.out.println("Number Plate: " + vehicle.getNumberPlate());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Time Parked: " + vehicle.getTimeParked());
            System.out.println();
        }

        // USE CASE 3: Check if the parking lot is full after unparking
        System.out.println("Is the Parking Lot Full? " + parkingLot.isFull());

        //USE CASE 5:
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        parkingLot.register(parkingLotOwner);
        System.out.println("Is the Parking Space Available? " + !(parkingLotOwner.isCapacityFull()));

    }
}
