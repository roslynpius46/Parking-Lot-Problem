package com.bridgelabz.parkinglot;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Implementation of Parking Lot Problem");

        // Create a Parking Lot with a capacity of 10
        ParkingLot parkingLot = new ParkingLot(10);

        // Create some vehicles
        Vehicle car1 = new Vehicle("ABC123", "Toyota", "Blue");
        Vehicle car2 = new Vehicle("XYZ789", "Honda", "Red");

        // Park vehicles in the Parking Lot
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);

        // Print information about parked vehicles
        System.out.println("Parked Vehicles:");
        for (Vehicle vehicle : parkingLot.getParkedVehicles()) {
            System.out.println("Number Plate: " + vehicle.getNumberPlate());
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Time Parked: " + vehicle.getTimeParked());
            System.out.println();
        }
    }
}
